package Componentes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.EventListenerList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JCheckBoxTree extends JTree
{

	private static final long serialVersionUID = -4194122328392241790L;

	JCheckBoxTree selfPointer = this;
	private boolean selectChilds=false;

	private class CheckedNode
	{
		boolean isSelected;
		boolean hasChildren;
		boolean allChildrenSelected;

		public CheckedNode(boolean isSelected_, boolean hasChildren_, boolean allChildrenSelected_)
		{
			isSelected = isSelected_;
			hasChildren = hasChildren_;
			allChildrenSelected = allChildrenSelected_;
		}

	}

	HashMap<TreePath, CheckedNode> nodesCheckingState;
	HashSet<TreePath> checkedPaths = new HashSet<TreePath>();

	// Defining a new event type for the checking mechanism and preparing
	// event-handling mechanism
	protected EventListenerList listenerList = new EventListenerList();
	
	public void setSelectChilds(boolean set) {
		this.selectChilds=set;
	}
	
	public boolean getSelectChilds() {
		return this.selectChilds;
	}

	public class CheckChangeEvent extends EventObject
	{
		private static final long serialVersionUID = -8100230309044193368L;

		public CheckChangeEvent(Object source)
		{
			super(source);
		}
	}

	public interface CheckChangeEventListener extends EventListener
	{
		public void checkStateChanged(CheckChangeEvent event);
	}

	public void addCheckChangeEventListener(CheckChangeEventListener listener)
	{
		listenerList.add(CheckChangeEventListener.class, listener);
	}

	public void removeCheckChangeEventListener(CheckChangeEventListener listener)
	{
		listenerList.remove(CheckChangeEventListener.class, listener);
	}

	void fireCheckChangeEvent(CheckChangeEvent evt)
	{
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i++)
		{
			if (listeners[i] == CheckChangeEventListener.class)
			{
				((CheckChangeEventListener) listeners[i + 1]).checkStateChanged(evt);
			}
		}
	}

	@Override
	public void setModel(TreeModel newModel)
	{
		super.setModel(newModel);
		resetCheckingState();
	}

	// New method that returns only the checked paths (totally ignores original
	// "selection" mechanism)
	public TreePath[] getCheckedPaths()
	{
		return checkedPaths.toArray(new TreePath[checkedPaths.size()]);
	}

	// Returns true in case that the node is selected, has children but not all of
	// them are selected
	public boolean isSelectedPartially(TreePath path)
	{
		CheckedNode cn = nodesCheckingState.get(path);
		return cn.isSelected && cn.hasChildren && !cn.allChildrenSelected;
	}

	private void resetCheckingState()
	{
		nodesCheckingState = new HashMap<TreePath, CheckedNode>();
		checkedPaths = new HashSet<TreePath>();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) getModel().getRoot();
		if (node == null)
		{
			return;
		}
		addSubtreeToCheckingStateTracking(node);
	}

	// Creating data structure of the current model for the checking mechanism
	private void addSubtreeToCheckingStateTracking(DefaultMutableTreeNode node)
	{
		TreeNode[] path = node.getPath();
		TreePath tp = new TreePath(path);
		CheckedNode cn = new CheckedNode(false, node.getChildCount() > 0, false);
		nodesCheckingState.put(tp, cn);
		for (int i = 0; i < node.getChildCount(); i++)
		{
			addSubtreeToCheckingStateTracking(
					(DefaultMutableTreeNode) tp.pathByAddingChild(node.getChildAt(i)).getLastPathComponent());
		}
	}

	@Override
	public void setSelectionRow(int row)
	{
		if (this.nodesCheckingState.get(this.getPathForRow(row)).isSelected)
			return;
		for (int i = 0; i < this.getRowCount(); i++)
		{
			this.expandRow(i);
		}
		this.nodesCheckingState.put(this.getPathForRow(row), new CheckedNode(true, false, false));

		// TreePath tp = this.getPathForRow(row);
		//
		// if (tp == null)
		// {
		// return;
		// }
		// boolean checkMode = nodesCheckingState.get(tp).isSelected;
		// if (isEnabled())
		// checkMode = nodesCheckingState.get(tp).isSelected;
		// checkSubTree(tp, checkMode);
		// updatePredecessorsWithCheckMode(tp, checkMode);
		// // Firing the check change event
		// fireCheckChangeEvent(new CheckChangeEvent(new Object()));
		// // Repainting tree after the data structures were updated
		selfPointer.repaint();
	}

	// Overriding cell renderer by a class that ignores the original "selection"
	// mechanism
	// It decides how to show the nodes due to the checking-mechanism
	private class CheckBoxCellRenderer extends JPanel implements TreeCellRenderer
	{
		private static final long serialVersionUID = -7341833835878991719L;
		JCheckBox checkBox;

		public CheckBoxCellRenderer()
		{
			super();
			this.setLayout(new BorderLayout());
			checkBox = new JCheckBox();
			add(checkBox, BorderLayout.CENTER);
			setOpaque(false);
		}

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
				boolean leaf, int row, boolean hasFocus)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			Object obj = node.getUserObject();
			TreePath tp = new TreePath(node.getPath());
			CheckedNode cn = nodesCheckingState.get(tp);
			if (cn == null)
			{
				return this;
			}
			checkBox.setSelected(cn.isSelected);
			checkBox.setText(obj.toString());
			checkBox.setOpaque(cn.isSelected && cn.hasChildren && !cn.allChildrenSelected);
			return this;
		}
	}

	public JCheckBoxTree()
	{
		super();
		// Disabling toggling by double-click
		this.setToggleClickCount(0);
		// Overriding cell renderer by new one defined above
		CheckBoxCellRenderer cellRenderer = new CheckBoxCellRenderer();
		this.setCellRenderer(cellRenderer);

		// Overriding selection model by an empty one
		DefaultTreeSelectionModel dtsm = new DefaultTreeSelectionModel()
		{
			private static final long serialVersionUID = -8190634240451667286L;

			// Totally disabling the selection mechanism
			public void setSelectionPath(TreePath path)
			{
			}

			public void addSelectionPath(TreePath path)
			{
			}

			public void removeSelectionPath(TreePath path)
			{
			}

			public void setSelectionPaths(TreePath[] pPaths)
			{
			}
		};
		// Calling checking mechanism on mouse click
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				TreePath tp = selfPointer.getPathForLocation(arg0.getX(), arg0.getY());
				if (tp == null)
				{
					return;
				}
				boolean checkMode = nodesCheckingState.get(tp).isSelected;
				if (isEnabled())
					checkMode = !nodesCheckingState.get(tp).isSelected;
				checkSubTree(tp, checkMode);
				updatePredecessorsWithCheckMode(tp, checkMode);
				// Firing the check change event
				fireCheckChangeEvent(new CheckChangeEvent(new Object()));
				// Repainting tree after the data structures were updated
				selfPointer.repaint();
			}

			public void mouseEntered(MouseEvent arg0)
			{
			}

			public void mouseExited(MouseEvent arg0)
			{
			}

			public void mousePressed(MouseEvent arg0)
			{
			}

			public void mouseReleased(MouseEvent arg0)
			{
			}
		});

	}

	private void addAncestorListener(ActionListener actionListener)
	{
		// TODO Auto-generated method stub

	}

	// When a node is checked/unchecked, updating the states of the predecessors
	protected void updatePredecessorsWithCheckMode(TreePath tp, boolean check)
	{
		TreePath parentPath = tp.getParentPath();
		// If it is the root, stop the recursive calls and return
		if (parentPath == null)
		{
			return;
		}
		CheckedNode parentCheckedNode = nodesCheckingState.get(parentPath);
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
		parentCheckedNode.allChildrenSelected = true;
		parentCheckedNode.isSelected = false;
		for (int i = 0; i < parentNode.getChildCount(); i++)
		{
			TreePath childPath = parentPath.pathByAddingChild(parentNode.getChildAt(i));
			CheckedNode childCheckedNode = nodesCheckingState.get(childPath);
			// It is enough that even one subtree is not fully selected
			// to determine that the parent is not fully selected
			if (!childCheckedNode.allChildrenSelected)
			{
				parentCheckedNode.allChildrenSelected = false;
			}
			// If at least one child is selected, selecting also the parent
			if (childCheckedNode.isSelected)
			{
				parentCheckedNode.isSelected = true;
			}
		}
		if (parentCheckedNode.isSelected)
		{
			checkedPaths.add(parentPath);
		} else
		{
			checkedPaths.remove(parentPath);
		}
		// Go to upper predecessor
		updatePredecessorsWithCheckMode(parentPath, check);
	}

	// Recursively checks/unchecks a subtree
	protected void checkSubTree(TreePath tp, boolean check)
	{
		CheckedNode cn = nodesCheckingState.get(tp);
		cn.isSelected = check;
		if (selectChilds)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
			for (int i = 0; i < node.getChildCount(); i++)
			{
				checkSubTree(tp.pathByAddingChild(node.getChildAt(i)), check);
			}
			cn.allChildrenSelected = check;
			if (check)
			{
				checkedPaths.add(tp);
			} else
			{
				checkedPaths.remove(tp);
			}
		}
	}

	public int SelectObject(String string, DefaultMutableTreeNode tree, int count)
	{
		DefaultMutableTreeNode a = tree;
		if (a.toString().equals(string))
		{
			this.setSelectionRow(count);
			DefaultTreeModel as = new DefaultTreeModel(a);
			JTree asdf = new JTree(as);
			return count + asdf.getRowCount() - 1;
		} else if (a.getChildCount() > 0)
		{
			for (int i = 0; i < a.getChildCount(); i++)
			{
				count = SelectObject(string, (DefaultMutableTreeNode) a.getChildAt(i), count + 1);
			}

		}
		return count;
	}

	public void clearSelections()
	{
		this.resetCheckingState();
	}

}