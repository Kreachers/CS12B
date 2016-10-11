/* Given the NodeObj structure and Node reerence from problem 9 above, write the following C functions:
 A. A constructor that returns a reference to a new NodeObj allocated from heap memory with its item
    field set to x and its next field set to NULL
 B. A destructor that frees the heap memory associated with a Node, and sets its reference to NULL
 C. A recursive function with heading void clearList(Node H) that frees all heap memory associated
    with a linked list headed by H */

typedef struct  NodeObj {
  int item;
  struct NodeObj* next;
} NodeObj;

typedef NodeObj* Node;

// A
Node new Node(int x) {
  Node N = malloc(sizeof(Node));
  assert( N!= NULL);
  N->item = x;
  N->next = NULL;
  return(N);
}

// B
void freeNode(Node* pN) {
  if (pN != NULL && *pN != NULL) {
    free(*pN);
    *pN = NULL;
  }
}

// C
void clearList(Node H) {
  while (H != NULL) {
    clearList(H->next);
    freeNode(&H);
  }
}
