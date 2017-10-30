/*
*	ListNode.h
*	Created on : June 1, 2015
*	Author : Conor O'Neill
*
*/

#include <iostream>
#include <cstdlib>
#include <cstddef>


template <class T> class ListNode
{
private:
	T data;
	ListNode<T>* next;
	ListNode<T>* prev;

public:
	ListNode();
	ListNode(T data);
	ListNode(T data, ListNode<T>* next, ListNode<T>* prev);
	T getData();
	ListNode<T>* getNext();
	ListNode<T>* getPrev();
	void setNext(ListNode<T>* node);
	void setPrev(ListNode<T>* node);
	void setData(T data);
};

/*
* Default Constructor for ListNode
*/
template <class T> ListNode<T>::ListNode()
{
	data = 0;
	next = NULL;
	prev = NULL;
}

/*
* Additional Constructor for ListNode
*/
template <class T> ListNode<T>::ListNode(T data)
{
	this->data = data;
	next = NULL;
	prev = NULL;
}

/*
* Additional Constructor for ListNode
*/
template <class T> ListNode<T>::ListNode(T data, ListNode<T>* next, ListNode<T>* prev)
{
	this->data = data;
	this->next = next;
	this->prev = prev;
	
}


/*
* -----------------------
* -----------------------
*		GETTERS
* -----------------------
* -----------------------
*/

template <class T> T ListNode<T>::getData()
{
	return data;
}

template <class T> ListNode<T>* ListNode<T>::getNext()
{
	if (next == NULL)
		return NULL;
	else
		return next;
}

template <class T> ListNode<T>* ListNode<T>::getPrev()
{
	if (prev == NULL)
		return NULL;
	else
		return prev;
}


/*
* -----------------------
* -----------------------
*		SETTERS
* -----------------------
* -----------------------
*/

template <class T> void ListNode<T>::setData(T data)
{
	this->data = data;
}

template <class T> void ListNode<T>::setNext(ListNode<T>* next)
{
	this->next = next;
}

template <class T> void ListNode<T>::setPrev(ListNode<T>* prev)
{
	this->prev = prev;
}


/*
* -----------------------
* -----------------------
*	END OF TEMPLATE
* -----------------------
* -----------------------
*/
