package com.qetch.datastructure.linkedlist;

public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
//		Node head = myLinkedList.new Node(3);
//		myLinkedList.head = head;
		myLinkedList.addNode(3);
		myLinkedList.addNode(1);
		myLinkedList.addNode(5);
		myLinkedList.addNode(3);
		myLinkedList.addNode(4);
		myLinkedList.addNode(2);
		myLinkedList.addNode(7);
		
		Node head = myLinkedList.head;
		
		// 返回链表的长度
		System.out.println("链表长度：" + myLinkedList.length());
		System.out.println("链表所有对象：");
		
		// 打印链表中所有的对象内容
		myLinkedList.printList();
	
		// 删除第index个节点
//		myLinkedList.deleteNode(4);
		
		// 在不知道头指针的情况下删除指定节点
//		myLinkedList.deleteNode(myLinkedList.head.next);
		
		// 1.链表反转
//		Node reverse_node = myLinkedList.reverseIteratively(head);
//		System.out.println("reverse_node" + reverse_node.data);
		
		// 2.查找单链表的中间节点
//		Node mid_node = myLinkedList.searchMid(head);
//		System.out.println("mid_node:" + mid_node.data);
		
		// 3.查找倒数第k个节点
		int k = 4;
		Node k_node = myLinkedList.findElem(head, k);
		System.out.println("k_node:" + k_node.data);
		
		// 4.对链表进行排序（data从小到大）
//		Node order_node = myLinkedList.orderList();
//		System.out.println("order_node:" + order_node.data);
		
		// 5.删除链表中的重复节点
//		myLinkedList.deleteDuplecate(head);
		
		// 6.从尾到头输出单链表，采用递归方式实现
//		myLinkedList.printListReversely(head);
		
		// 7.1.判断链表是否有环，单向链表有环时，尾节点相同
//		System.out.println(myLinkedList.isLoop(head));
		
		// 7.2.找出链表环的入口
//		Node port_node = myLinkedList.findLoopPort(head);
//		System.out.println("port_node:" + port_node);
		
		System.out.println("------------");
		System.out.println("链表所有对象：");
		myLinkedList.printList();
	}
	
	Node head = null;		// 头节点
	
	/**
	 * 链表中的节点，data代表节点的值，next是指向下一个节点的引用
	 * @author ZCW
	 *
	 */
	class Node {
		Node next = null;	// 节点的引用，指向下一个节点
		int data;			// 节点的对象，即内容
		public Node(int data) {
			this.data = data;
		}
	}
	
	/**
	 * 返回链表的长度
	 * @return
	 */
	public int length() {
		int length = 0;
		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}

	/**
	 * 打印链表中所有的对象内容
	 */
	public void printList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp + "---" + tmp.data);
			tmp = tmp.next;
		}
	}
	
	/**
	 * 向链表中插入数据
	 * @param d
	 */
	public void addNode(int d) {
		Node newNode = new Node(d); // 实例化一个节点
		if (null == head) {
			head = newNode;
			return;
		}
		
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	/**
	 * 删除第index个节点
	 * @param index
	 * @return
	 */
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		if (index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (curNode != null) {
			if ((i + 1) == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return false;
	}
	
	/**
	 * 在不知道头指针的情况下删除指定节点
	 * @param n
	 * @return
	 */
	public boolean deleteNode(Node n) {
		if (null == n || null == n.next) {
			return false;
		}
		int tmp = n.data;
		n.data = n.next.data;
		n.next.data = tmp;
		n.next = n.next.next;
		System.out.println("删除成功！");
		return true;
	}
	
	/**
	 * 链表相关的常用操作实现方法
	 */
	
	/**
	 * 1.链表反转
	 * @param head
	 * @return
	 */
	public Node reverseIteratively(Node head) {
		Node pReversedHead = head;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			Node pNext = pNode.next;
			if (null == pNext) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReversedHead;
		return this.head;
	}
	
	/**
	 * 2.查找单链表的中间节点
	 * 实现：采用快慢指针的方式查找单链表的中间节点，快指针一次走两步，慢指针一次走一步，当快指针走完时，慢指针刚好到达中间节点。
	 * @param head
	 * @return
	 */
	public Node searchMid(Node head) {
		Node p = this.head;
		Node q = this.head;
		while (p != null && p.next != null && p.next.next != null) {
			p = p.next.next;// 快指针
			q = q.next;		// 慢指针
		}
		System.out.println("Mid Node is " + q.data);
		return q;
	}
	
	/**
	 * 3.查找倒数第k个节点
	 * 实现：采用两个指针p1和p2，p1先前移k步，然后p1和p2同时移动，当p1移动到尾部时，p2所指位置的节点即为倒数第k个节点。
	 * @param head
	 * @param k
	 * @return
	 */
	public Node findElem(Node head, int k) {
		if (k < 1 || k > length()) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++) {// p1先前移k步
			p1 = p1.next;
		}
		while (p1 != null) {// p1和p2同时移动，直到p1移到尾部
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("倒数第" + k + "个节点为：" + p2.data);
		return p2;
	}
	
	/**
	 * 4.对链表进行排序（data从小到大）
	 * @return
	 */
	public Node orderList() {
		Node nextNode = null;
		int tmp = 0;
		Node curNode = head;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					tmp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	
	/**
	 * 5.删除链表中的重复节点
	 * @param head
	 */
	public void deleteDuplecate(Node head) {
		Node p = head;
		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
			}
			p = p.next;
		}
	}
	
	/**
	 * 6.从尾到头输出单链表，采用递归方式实现
	 * @param head
	 */
	public void printListReversely(Node head) {
		if (head != null) {
			printListReversely(head.next);
			System.out.println("printListReversely:" + head.data);
		}
	}
	
	/**
	 * 7.1.判断链表是否有环，单向链表有环时，尾节点相同
	 * @param head
	 * @return
	 */
	public boolean isLoop(Node head) {
		Node fast = head, slow = head;
		if (null == fast) {
			return false;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				System.out.println("该链表有环！");
				return true;
			}
		}
		return !(null == fast || null == fast.next);
	}
	
	/**
	 * 7.2.找出链表环的入口
	 * @param head
	 * @return
	 */
	public Node findLoopPort(Node head) {
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (null == fast || null == fast.next) {
			return null;
		}
		slow = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	/**
	 * 8.1.判断两个链表是否相交
	 * @param: @param h1
	 * @param: @param h2
	 * @param: @return
	 * @return: boolean
	 * @throws
	 */
	public boolean isIntersect(Node h1, Node h2) {
		if (null == h1 || null == h2) {
			return false;
		}
		Node tail1 = h1;
		// 找到链表h1的最后一个节点
		while (tail1.next != null) {
			tail1 = tail1.next;
		}
		
		Node tail2 = h2;
		// 找到链表h2的最后一个节点
		while (tail2.next != null) {
			tail2 = tail2.next;
		}

		return tail1 == tail2;
	}
	
	/**
	 * 8.2.如果两个链表相交，如何找到它们相交的第一个节点
	 * @Title: getFirstMeetNode
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param h1
	 * @param: @param h2
	 * @param: @return
	 * @return: Node
	 * @throws
	 */
	public Node getFirstMeetNode(Node h1, Node h2) {
		if (null == h1 || null == h2) {
			return null;
		}
		Node tail1 = h1;
		int len1 = 1;
		// 找到链表h1的最后一个节点
		while (tail1.next != null) {
			tail1 = tail1.next;
			len1++;
		}
		
		Node tail2 = h2;
		int len2 = 1;
		// 找到链表h2的最后一个节点
		while (tail2.next != null) {
			tail2 = tail2.next;
			len2++;
		}
		
		// 两链表不相交
		if (tail1 != tail2) {
			return null;
		}
		
		Node t1 = h1;
		Node t2 = h2;
		// 找出较长的链表，先遍历
		if (len1 > len2) {
			int d = len1 - len2;
			while (d != 0) {
				t1 = t1.next;
				d--;
			}
		} else {
			int d = len2 - len1;
			while (d != 0) {
				t2 = t2.next;
				d--;
			}
		}
		while (t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;
		}
		return t1;
	}
}
