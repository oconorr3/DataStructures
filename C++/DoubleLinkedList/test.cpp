
/*
*
*  Created on: May 29, 2015
*      Author: ConorO'Neill
*/


#include "LinkedList.h"
using namespace std;


int main(int argc, char *argv[])
{
	/*
	* -----------------------
	* -----------------------
	*		NODE TESTS
	* -----------------------
	* -----------------------
	*/
	ListNode<int>* a = new ListNode<int>(1);
	ListNode<int>* b = new ListNode<int>(2);
	a->setNext(b);
	
	//for (int i = 0; i < 10000; i++)
		//cout << a->getNext()->getData() << endl;


	/*
	* -----------------------
	* -----------------------
	* DOUBLE LINKED LIST TESTS
	* -----------------------
	* -----------------------
	*/
	LinkedList<int> list;
	list.addLast(1);
	list.addLast(2);
	list.addLast(3);
	list.addLast(4);
	//list.removeFirst();
	//for (int j = 0; j < list.size; j++)
		list.iterateForward();

}
