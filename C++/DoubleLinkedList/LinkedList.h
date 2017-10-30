

/*
*	ListNode.h
*	Created on : June 1, 2015
*	Author : Conor O'Neill
*
*/

#include <iostream>
#include <cstdlib>
#include <cstddef>
#include "ListNode.h"


template <class T> class LinkedList
{
private:
	ListNode<T>* head;	//sentinal node before first item
	ListNode<T>* tail;	//sentinel node after last item

public:
	int size;			//amount of elements in list
	LinkedList();
	~LinkedList();
	int getSize();
	void addFirst(T data);
	void addLast(T data);
	void removeFirst();
	void removeLast();
	void iterateForward();
	void iterateBackward();
};

/*
*	Constructor for Doubly Linked Linked
*/
template <class T> LinkedList<T>::LinkedList()
{
	size = 0;
	head = new ListNode<T>();
	tail = new ListNode<T>();
	head->setNext(tail);
	tail->setPrev(head);
}

/*
*	Destructor for Doubly Linked Linked List
*/
template <class T> LinkedList<T>::~LinkedList()
{
	ListNode<T>* curr = head;
    while (head)
    {
        head = head->getNext();
        delete curr;
        curr = head;
    }
}


/*
*	return the amount of elements in the list 
*/
template <class T> int LinkedList<T>::getSize()
{
	return size;
}

/*
*	insert at the beginning (by the head) of the list
*/
template <class T> void LinkedList<T>::addFirst(T data)
{
	ListNode<T>* tmp = new ListNode<T>(data);
	tmp->setNext(head);
	if (head != NULL)
		head->setPrev(tmp);
	
	if (tail == NULL)
		tail = tmp;
	
	head = tmp;
	size++;
	
}

/*
*	insert at the end (by the tail) of the list
*/
template <class T> void LinkedList<T>::addLast(T data)
{
	ListNode<T>* tmp = new ListNode<T>(data);
	tmp->setPrev(tail);
	if (tail != NULL)
		tail->setNext(tmp);
	
	
	if (head == NULL)
		head = tmp;
	
	tail = tmp;
	size++;
}


/*
*	remove at the beginning (by the head) of the list
*/
template <class T> void LinkedList<T>::removeFirst()
{
	if (size == 0)
		return;
	else
	{
		ListNode<T>* tmp = head;
		head = head->getNext();
		head->setPrev(NULL);
		size--;
	}
}

/*
*	remove at the end (by the tail) of the list
*/
template <class T> void LinkedList<T>::removeLast()
{
	if (size == 0)
		return;
	else
	{
		ListNode<T>* tmp = tail;
		tail = tail->getPrev();
		tail->setNext(NULL);
		size--;
	}
}

/*
*	print the list from the front
*/
template <class T> void LinkedList<T>::iterateForward()
{
	
	ListNode<T>* tmp = head;
	while (tmp != NULL)
	{
		std::cout << tmp->getData() << " <--> ";
		tmp = tmp->getNext();
	}
	std::cout << "NULL\n";
}

/*
*	print the list from the rear
*/
template <class T> void LinkedList<T>::iterateBackward()
{
	
	ListNode<T>* tmp = tail;
	while (tmp != NULL)
	{
		std::cout << tmp->getData() << " <--> ";
		tmp = tmp->getPrev();
	}
	std::cout << "NULL\n";
}





