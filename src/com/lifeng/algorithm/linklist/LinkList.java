package com.lifeng.algorithm.linklist;

import java.util.PriorityQueue;

/**
 * @description: 单链表常见问题
 * @author: lifeng
 * @create: 2021-12-21 16:03:37
 **/

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class LinkList {
    /**
     * 反转链表 leetcode206
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        pre.next = head;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListdg(ListNode head){
        if(head.next ==null) return head;
        ListNode last = reverseListdg(head.next);
        head.next.next = head;
        head.next =null;
        return last;
    }

    /**
     * 反转以head为起点的n个节点，返回新的头结点
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;
    public ListNode reverserN(ListNode head,int n){
        if(n==1){
            successor = head.next;
            return head;
        }
        ListNode last = reverserN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 应用到反转链表II上
     * 反转a-b区间范围「区间为左闭右闭」
     * @param a
     * @param b
     * @return
     */
    public ListNode reverseBetween(ListNode a,ListNode b){
        ListNode pre = null;
        pre.next = a;
        ListNode cur = a;
        while(pre!=b){//区间为左闭右闭时，前置指针到达b是退出循环
            ListNode next =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 应用到K个一组反转题目上的「左闭右开反转写法」
     * @param a
     * @param b
     * @return
     */
    public ListNode reverseBetweenAb(ListNode a,ListNode b){
        ListNode pre = null;
        pre.next = a;
        ListNode cur = a;
        while(cur!=b){//区间为左闭右开，当前指针到达b时退出循环
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseGroup(ListNode head,int k){
        if(head ==null) return null;
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b==null) return head;
            b = b.next;
        }
        ListNode newHead= reverseBetweenAb(a,b);
        a.next = reverseGroup(b,k);
        return newHead;
    }

    /**
     * 合并链表-拉链法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1= l1,p2 = l2;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p= p.next;
        }
        if(p1!=null){
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;
        }
        return dummy.next;
    }

    /**
     * 合并链表-递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergetwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next = mergetwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergetwoLists(l1,l2.next);
            return l2;
        }

    }

    /**
     * 合并K个链表-使用优先队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b)->(a.val-b.val));
        for (ListNode head:lists){
            if(head!=null){
                queue.offer(head);
            }
        }
        while(queue!=null){
            ListNode node = queue.poll();
            p.next = node;
            if(node.next!=null){
                queue.offer(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 返回链表倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode findfromEnd(ListNode head,int k){
        ListNode p1 = head,p2 = head;
        //p1先走K步，剩余n-k到达末尾
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        //p1和p2同时走n-k步
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //p2最后指向第n-k个节点
        return p2;
    }

    /**
     * 删除链表倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //使用虚拟头节点为了防止出现空指针的情况
        //获取N+1为了取到删除节点
        ListNode x = findfromEnd(dummy,n+1);
        x.next = x.next.next;
        return dummy.next;
    }
    public ListNode removeNthFromEndpoint(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode res = dummy.next;
        return res;
    }

    /**
     * 链表中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 判断链表是否有环，有则返回环起点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        ListNode fast,slow;
        fast = slow = head;
        while(fast!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next==null){
            return null;
        }
        slow = head;
        while(slow!=fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null || headB==null){
            return null;
        }
        ListNode pA = headA,pB = headB;
        while(pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
        }
        return pA;
    }



}


