// Bradley Bernard, bmbernar@ucsc.edu
// CS 101: PA2
// July 7, 2015
// $Id: List.c,v 1.2 2015-08-10 15:31:42-07 - - $

//-----------------------------------------------------------------------------
// List.c
// Implementation file for List ADT
//-----------------------------------------------------------------------------


#include<stdio.h>
#include<stdlib.h>

#include "List.h"


typedef struct NodeObj {
   int data;
   struct NodeObj* next;
   struct NodeObj* prev;
} NodeObj;

typedef NodeObj* Node;

typedef struct ListObj {
   Node front;
   Node back;
   Node cursor;
   int length;
   int index;
} ListObj;

// Creates a Node with int data, Node prev, and Node next.
Node newNode(int data, Node prev, Node next) {
   Node N = malloc(sizeof(NodeObj));
   N->data = data;
   N->prev = prev;
   N->next = next;
   return(N);
}
// Free memory for the Node.
void freeNode(Node* pN) {
   if(pN != NULL && *pN != NULL) {
      free(*pN);
      *pN = NULL;
   }
}

// Creates a new empty List.
List newList(void){
   List L;
   L = malloc(sizeof(ListObj));
   L->front = L->back = L->cursor = NULL;
   L->length = 0;
   L->index = -1;
   return(L);
}

// Free memory for the List and the Nodes inside.
void freeList(List* pL) {
   if(pL != NULL && *pL != NULL) { 
      Node tmp = (*pL)->front; 
      while(tmp != NULL) {
         Node cur = tmp;
         tmp = tmp->next;
         free(cur);
      }
      free(*pL);
      *pL = NULL;
   }
}

// Returns the number of elements in this List.
int length(List L) {
   if(L == NULL) {
      printf("List Error: calling length() on NULL List reference\n");
      exit(1);
   }
   return L->length;
}

// If cursor is defined, returns the index of the cursor
// element, otherwise returns -1.
int index(List L) {
   if(L == NULL) {
      printf("List Error: calling index() on NULL List reference\n");
      exit(1);
   }
   return L->index;
}

// Returns front element.
// Pre: length() > 0
int front(List L) {
   if(L == NULL) {
      printf("List Error: calling front() on NULL List reference\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: calling front() on empty List reference\n");
      exit(1);
   }
   return L->front->data;
}

// Returns back element.
// Pre: length() > 0
int back(List L) {
   if(L == NULL) {
      printf("List Error: calling back() on NULL List reference\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: calling back() on empty List reference\n");
      exit(1);
   }
   return L->back->data;
}

// Returns cursor element.
// Pre: length() > 0
int get(List L) {
   if(L == NULL) {
      printf("List Error: calling get() on NULL List reference\n");
      exit(1);
   }
   if(L->index < 0) {
      printf("List Error: calling get() with an undefined index on List\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: calling get() on empty List reference\n");
      exit(1);
   }
   return L->cursor->data;
}

// Returns true if this List and L are the same integer
// sequence. The cursor is ignored in both lists.
int equals(List A, List B) {
   if(A == NULL || B == NULL) {
      printf("List Error: calling equals() on NULL List reference\n");
      exit(1);
   }
   if(A->length != B->length) {
      return 0;
   }
   Node cfront = B->front;
   Node tmp = A->front;
   while(cfront->next != NULL && tmp->next != NULL) {
      if(cfront->data != tmp->data)
         return 0;
      cfront = cfront->next;
      tmp = tmp->next;
   }
   return 1;
}

// Resets this List to its original empty state.
void clear(List L) {
   if(L == NULL) {
      printf("List Error: calling clear() on NULL List reference\n");
      exit(1);
   }
   Node tmp = L->front; 
   while(tmp != NULL) {
      Node cur = tmp;
      tmp = tmp->next;
      free(cur);
   }
   L->front = L->back = L->cursor = NULL;
   L->length = 0;
   L->index = -1;
}

// If List is non-empty, places the cursor under the front
// element, otherwise does nothing.
void moveFront(List L) {
   if(L == NULL) {
      printf("List Error: calling moveFront() on NULL List reference\n");
      exit(1);
   }
   if(L->length > 0) {
      L->cursor = L->front;
      L->index = 0;
   }
}

// If List is non-empty, places the cursor under the back
// element, otherwise does nothing.
void moveBack(List L) {
   if(L == NULL) {
      printf("List Error: calling moveBack() on NULL List reference\n");
      exit(1);
   }
   if(L->length > 0) {
      L->cursor = L->back;
      L->index = L->length - 1;
   }
}

// If cursor is defined and not at front, moves cursor one step
// toward the front of this List, if cursor is defined and at front,
// cursor becomes undefined, if cursor is undefined does nothing.
void movePrev(List L) {
   if(L == NULL) {
      printf("List Error: calling movePrev() on NULL List reference\n");
      exit(1);
   }
   if(L->cursor != NULL && L->index != 0) {
      L->cursor = L->cursor->prev;
      --L->index;
   }
   else if(L->cursor != NULL && L->index == 0) {
      L->cursor = NULL;
      L->index = -1;
   }
}

// If cursor is defined and not at back, moves cursor one step
// toward the back of this List, if cursor is defined and at back,
// cursor becomes undefined, if cursor is undefined does nothing.
void moveNext(List L) {
   if(L == NULL) {
      printf("List Error: calling moveNext() on NULL List reference\n");
      exit(1);
   }
   if(L->cursor != NULL && L->cursor != L->back) {
      L->cursor = L->cursor->next;
      ++L->index;
   }
   else if(L->cursor != NULL && L->cursor == L->back) {
      L->cursor = NULL;
      L->index = -1;
   }
}

// Insert new element into this List. If List is non-empty,
// insertion takes place before the front element.
void prepend(List L, int data) {
   if(L == NULL) {
      printf("List Error: calling prepend() on NULL List reference\n");
      exit(1);
   }
   Node tmp = newNode(data, NULL, L->front);
   if(L->front == NULL)
      L->back = tmp;
   else
      L->front->prev = tmp;
   L->front = tmp;
   ++L->length;
}

// Insert new element into this List. If List is non-empty,
// insertion takes place after back element.
void append(List L, int data) {
   if(L == NULL) {
      printf("List Error: calling append() on NULL List reference\n");
      exit(1);
   }
   Node tmp = newNode(data, L->back, NULL);
   if(L->front == NULL)
      L->front = tmp;
   else
      L->back->next = tmp;
   L->back = tmp;
   ++L->length;
}

// Insert new element before cursor.
// Pre: length() > 0, index() >= 0
void insertBefore(List L, int data) {
   if(L == NULL) {
      printf("List Error: calling insertBefore() on NULL List reference\n");
      exit(1);
   }
   if(L->index < 0) {
      printf("List Error: insertBefore() called with an undefined index on List");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: insertBefore() called on an empty List");
      exit(1);
   }
   Node tmp = newNode(data, L->cursor->prev, L->cursor);
   if(L->cursor->prev != NULL)
      L->cursor->prev->next = tmp;
   else
      L->front = tmp;
   L->cursor->prev = tmp;
   ++L->length;
}

// Insert new element after cursor.
// Pre: length() > 0, index() >= 0
void insertAfter(List L, int data) {
   if(L == NULL) {
      printf("List Error: calling insertAfter() on NULL List reference\n");
      exit(1);
   }
   if(L->index < 0) {
      printf("List Error: insertAfter() called with an undefined index on List");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: insertAfter() called on an empty List");
      exit(1);
   }
   Node tmp = newNode(data, L->cursor, L->cursor->next);
   if(L->cursor->next != NULL)
      L->cursor->next->prev = tmp;
   else
      L->back = tmp;
   L->cursor->next = tmp;
   ++L->length;
}

// Deletes the front element.
// Pre: length() > 0
void deleteFront(List L) {
   if(L == NULL) {
      printf("List Error: deleteFront() called on NULL List reference\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: deleteFront() called on an empty List\n"); 
      exit(1);
   }
   if(L->cursor == L->front) {
      L->cursor = NULL;
      L->index = -1;
   }
   Node tmp = L->front;
   L->front = L->front->next;
   L->front->prev = NULL;
   --L->length;
   freeNode(&tmp);
}

// Deletes the back element.
// Pre: length() > 0
void deleteBack(List L) {
   if(L == NULL) {
      printf("List Error: deleteBack() called on NULL List reference\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: deleteBack() called on an empty List\n");
      exit(1);
   }
   if(L->cursor == L->back) {
      L->cursor = NULL;
      L->index = -1;
   }
   if(L->back == L->front)
      L->front = NULL;

   Node tmp = L->back;
   if(L->back->prev != NULL)
      L->back = L->back->prev;
   L->back->next = NULL;
   --L->length;
   freeNode(&tmp);
}

// Deletes cursor element, making cursor undefined.
// Pre: length() > 0, index() >= 0
void delete(List L) {
   if(L == NULL) {
      printf("List Error: delete() called on NULL List reference\n");
      exit(1);
   }
   if(L->length < 1) {
      printf("List Error: delete() called with an undefined index on List\n");
      exit(1);
   }
   if(L->index < 0) {
      printf("List Error: delete() called on empty List");
      exit(1);
   }
   if(L->cursor == L->back) {
      deleteBack(L);
   } else if(L->cursor == L->front) {
      deleteFront(L);
   } else {
      Node tmp = L->cursor;
      L->cursor->prev->next = L->cursor->next;
      L->cursor->next->prev = L->cursor->prev;
      freeNode(&tmp);
      L->cursor = NULL;
      L->index = -1;
      --L->length;
   }
}

// Overrides Object's toString method. Returns a String
// representation of this List consisting of a space
// separated sequence of integers, with front on left.
void printList(FILE* out, List L) {
   Node tmp = L->front;
   int i = 0;
   while(tmp != NULL) {
      if(i != 0)
         fprintf(out, " %d", tmp->data);
      else 
         fprintf(out, "%d", tmp->data);
      tmp = tmp->next;
      ++i;
   }
}

// Returns a new List representing the same integer sequence as this
// List. The curor in the new list is undefined, regardless of the
// state of the cursor in this List. This List is unchanged.
List copyList(List L) {
   List c = newList();
   Node tmp = L->front;
   while(tmp != NULL) {
      append(c, tmp->data);
      tmp = tmp->next;
   }
   return c;
}

// Returns a new List which is the concatenation of
// this list followed by L. The cursor in the new List
// is undefined, regardless of the states of the cursors
// in this List and L. The states of this List and L are
// unchanged.
List concat(List L) {
   List cc = newList();
   Node tmp = L->front;
   while(tmp != NULL) {
      append(cc, tmp->data);
      tmp = tmp->next;
   }
   return cc;
}
