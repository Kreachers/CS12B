/* Fill in the definition of the C function below called printPreOrder(). This function will, given the root
N of a binary search tree based on the Node structure below, print out the keys according to a pre-order tree
traversal. Write similar functions called printInOrder() and printPostOrder() that print in-order
and post-order tree traversals respectively */

typedef struct NodeObj {
  int key;
  struct NodeObj* left;
  struct NodeObj* right;
} NodeObj;

typedf NodeObj* Node;

void printPreOrder(Node N) {
  if (N != NULL) {
    printf("%d ", r->value);
    printPreOrder(N->left);
    printPreOrder(N->right);
  }
}

void printInOrder(Node N) {
  if (N != NULL) {
    printInOrder(N->left);
    printf("%d ", r->value);
    printInOrder(N->right);
  }
}

void printPostOrder(Node N) {
  if (N != NULL) {
    printPostOrder(N->left);
    printPostOrder(N->right);
    printf("%d ", r->value);
  }
}

/* PreOrder (current, left, right)
   InOrder (left, current, right)
   PostOrder (left, right, current) */
