// Bradley Beranrd, bmbernar@ucsc.edu
// CS 101: PA5
// Aug 7, 2015
// $Id: Graph.c,v 1.2 2015-08-10 15:31:42-07 - - $

#include <stdio.h>
#include <stdlib.h>

#include "Graph.h"

// Enum for DFS algorithm
#define WHITE 0
#define GRAY 1
#define BLACK 2

struct GraphObj {
   List *adj;
   int *color;
   int *parent;
   int *discover;
   int *finish;
   int order;
   int size;
};

// Returns a pointer to a new GraphObj
Graph newGraph(int n) {
   Graph G = malloc(sizeof(struct GraphObj));
   G->adj = calloc(n + 1, sizeof(List));
   G->color = calloc(n + 1, sizeof(int));
   G->parent = calloc(n + 1, sizeof(int));
   G->discover = calloc(n + 1, sizeof(int));
   G->finish = calloc(n + 1, sizeof(int));
   G->order = n;
   G->size = 0;
   for(int i = 0; i < (n + 1); ++i) {
      G->adj[i] = newList();
      G->color[i] = WHITE;
      G->parent[i] = NIL;
      G->discover[i] = UNDEF;
      G->finish[i] = UNDEF;
   }
   return G;
}

// Frees memory allocate to a GraphObj
void freeGraph(Graph *pG) {
   Graph old = *pG;
   for(int i = 0; i < (old->order + 1); ++i) {
      freeList(&(old->adj[i]));
   }
   free(old->adj);
   free(old->parent);
   free(old->discover);
   free(old->finish);
   free(old->color);
   free(*pG);
   *pG = NULL;
}

// Returns the number of verticies in the Graph
int getOrder(Graph G) {
   return G->order;
}

// Returns the number of edges in the Graph
int getSize(Graph G) {
   return G->size;
}

// Returns the parent of a given vertex
// Pre: 1 <= u <= n = getOrder(G)
int getParent(Graph G, int u) {
   if(u < 1 || u > getOrder(G)) {
     printf("Graph Error: calling getParent() with vertex out of bounds\n");
     exit(1); 
   }
   return G->parent[u];
}

// Returns the discover time of a given vertex
// Pre: 1 <= u <= n = getOrder(G)
int getDiscover(Graph G, int u) {
   if(u < 1 || u > getOrder(G)) {
     printf("Graph Error: calling getDiscover() with vertex out of bounds\n");
     exit(1); 
   }
   return G->discover[u];
}

// Returns the finish time of a given vertex
// Pre: 1 <= u <= n = getOrder(G)
int getFinish(Graph G, int u) {
   if(u < 1 || u > getOrder(G)) {
     printf("Graph Error: calling getFinish() with vertex out of bounds\n");
     exit(1); 
   }
   return G->finish[u];
}

// Adds an undirected edge to the Graph G from u to v
// Pre: 1 <= u <= getOrder(G), 1 <= v <= getOrder(G)
void addEdge(Graph G, int u, int v) {
   if(u < 1 || u > getOrder(G) || v < 1 || v > getOrder(G)) {
     printf("Graph Error: calling addEdge() with verticies out of bounds\n");
     exit(1); 
   }
   addArc(G, u, v);
   addArc(G, v, u);
   G->size--;
}

// Adds a directed edge to the Graph G from u to v
// Pre: 1 <= u <= getOrder(G), 1 <= v <= getOrder(G)
void addArc(Graph G, int u, int v) {
   if(u < 1 || u > getOrder(G) || v < 1 || v > getOrder(G)) {
     printf("Graph Error: calling addArc() with verticies out of bounds\n");
     exit(1); 
   }
   List S = G->adj[u];
   moveFront(S);
   while(index(S) > -1 && v > get(S)) {
      moveNext(S);
   }
   if(index(S) == -1)
      append(S, v);
   else 
      insertBefore(S, v);
   G->size++;
}

// Recursive part of DFS that hits all vertices
// on a vertex's adj list.
void Visit(Graph G, List S, int u, int *time) {
   G->color[u] = GRAY;
   G->discover[u] = ++*time;
   moveFront(G->adj[u]);
   while(index(G->adj[u]) >= 0) {
      int v = get(G->adj[u]);
      if(G->color[v] == WHITE) {
         G->parent[v] = u;
         Visit(G, S, v, time);
      }
      moveNext(G->adj[u]);
   }
   G->color[u] = BLACK;
   G->finish[u] = ++*time;
   prepend(S, u);
}

// Performs Depth-first search with the vertices in the order
// of List S.
// Pre: length(S) == getOrder(G)
void DFS(Graph G, List S) {
   if(length(S) != getOrder(G)) {
      printf("Graph Error: called DFS() without matching sizes\n");
      exit(1);
   }
   for(int i = 1; i <= getOrder(G); ++i) {
      G->color[i] = WHITE;
      G->parent[i] = NIL;
      G->discover[i] = UNDEF;
      G->finish[i] = UNDEF;
   }
   int time = 0;
   moveFront(S);
   while(index(S) >= 0) {
      int u = get(S);
      if(G->color[u] == WHITE) {
         Visit(G, S, u, &time);   
      }
      moveNext(S);
   }

   for(int size = length(S)/2; size > 0; --size) {
      deleteBack(S);
   }
}

// Prints out the Graph by iterating over and printing out
// each adjacency list with the row number preceeding it.
void printGraph(FILE *out, Graph G) {
   if(out == NULL || G == NULL) {
      printf("Graph Error: called printGraph() on a null reference\n");
      exit(1);
   }
   for(int i = 1; i <= getOrder(G); ++i) {
      fprintf(out, "%d: ", i);
      printList(out, G->adj[i]);
      fprintf(out, "\n");
   }
}

// Returns a copy of a given Graph
Graph copyGraph(Graph G) {
   Graph C = newGraph(getOrder(G));
   for(int i = 1; i <= getOrder(G); ++i) {
      moveFront(G->adj[i]);
      while(index(G->adj[i]) >= 0) {
         addArc(C, i, get(G->adj[i])); 
         moveNext(G->adj[i]);
      }
   }
   return C;
}

// Returns the transpose of a given Graph
Graph transpose(Graph G) {
   Graph T = newGraph(getOrder(G));
   for(int i = 1; i <= getOrder(G); ++i) {
      moveFront(G->adj[i]);
      while(index(G->adj[i]) >= 0) {
         addArc(T, get(G->adj[i]), i);
         moveNext(G->adj[i]);  
      }
   }
   return T;
}
