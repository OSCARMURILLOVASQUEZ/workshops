#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <malloc.h>
#include <iostream>

//Descripción Principal de ArbolBinario
struct ArbolBinario{
	int dato;
	ArbolBinario *izq;
	ArbolBinario *der;
};

//Creación de ArbolBinario como Tipo de dato definido por el usuario
typedef struct ArbolBinario AB;

//Protipo de funciones y operaciones de Arboles Bonarios
AB *crearArbolBinarioRecursivo(AB *nodo);
AB *crearArbolBinarioAleatorio(AB *nodo, int nivel);
void imprimirArbolBinario(AB *arbol, int nivel, int padre, char lado);
AB *crearNododeArbol(bool generar);
void preorden(AB *arbol);
void inorden(AB *arbol);
void postorden(AB *arbol);
int imprimirMenu(void);

int main(int argc, char** argv) {
	srand(time(NULL));
	int op;
	int nivel;
	AB *arbol = NULL;
	do{
		op=imprimirMenu();
		switch(op){
			case 1:
				free(arbol);
				arbol = crearArbolBinarioRecursivo(arbol);
				break;
			case 2:
				free(arbol);
				printf("Digite el Numero de Niveles del Arbol: \t"); 
				scanf("%i",&nivel);
				arbol = crearArbolBinarioAleatorio(arbol,nivel);
				imprimirArbolBinario(arbol, nivel,0,'R');
				printf("\n"); 
				system("PAUSE");
				break;
			case 8:
				//Hacer función de calcular el nivel del arbol
				// y pasarla por parámetro a la función de imprimir
				imprimirArbolBinario(arbol, 3, 0,'R');
				printf("\n"); 
				system("PAUSE");
				break;												
			case 9:
				printf("\n"); 
				printf("Preorden: \t"); preorden(arbol);printf("\n"); 
				printf("Inorden: \t"); inorden(arbol);printf("\n"); 
				printf("Postorden: \t"); postorden(arbol);printf("\n"); 
				system("PAUSE");
				break;				
			case 0:
				printf("Gracias por utilizar nuestros servicios. \n"); 
				printf("Vuelva pronto. \n"); 
				system("PAUSE");
				break;		
			default:
				printf("\n\n Opción Incorrecta. \n"); 
				system("PAUSE");
				break;
		}
	}while(op != 0);
	return 0;
}

AB *crearArbolBinarioRecursivo(AB *nodo){
	AB *hijo = NULL;
	if (nodo == NULL){
		nodo = crearNododeArbol(false);
	}
	int desicion = -1;
	printf("Desea viajar por la Izquierda? (1)Si o (0)No :\t");
	scanf("%i",&desicion);
	if(desicion == 1){
		hijo=crearArbolBinarioRecursivo(nodo->izq);
		nodo->izq=hijo;
	}
	printf("Desea viajar por la Derecha? (1)Si o (0)No :\t"); 
	scanf("%i",&desicion);
	if(desicion == 1){
		hijo=crearArbolBinarioRecursivo(nodo->der);
		nodo->der=hijo;
	}
	printf("Devolviendome del contexto de %i \n",nodo->dato); 
	return nodo;
}

AB *crearArbolBinarioAleatorio(AB *nodo, int nivel){
	AB *hijo = NULL;
	int desicion;
	if (nodo == NULL){
		nodo = crearNododeArbol(true);
	}
	if (nivel >= 0){
		nivel--;
		desicion = rand()%10;
		if(desicion <= 7){
			hijo=crearArbolBinarioAleatorio(nodo->izq,nivel);
			nodo->izq=hijo;
		}
		desicion = rand()%10;
		if(desicion <= 7){
			hijo=crearArbolBinarioAleatorio(nodo->der,nivel);
			nodo->der=hijo;
		}
	}
	return nodo;
}

AB *crearNododeArbol(bool generar){
	AB *nodo = NULL;

	int dato = rand()%50;
	if (!generar){
		printf("Digite el Numero a Guardar:\t"); 
		scanf("%i",&dato);
	}
	nodo = (AB *)malloc(sizeof (AB));
	nodo->dato = dato;
	nodo->der = NULL;
	nodo->izq = NULL;
	return nodo;
}

void imprimirArbolBinario(AB *arbol, int nivel, int padre, char lado) {
	int i;
	if(arbol) {
		imprimirArbolBinario(arbol->der,nivel+1, arbol->dato,'D');
		printf("\n\n");
		for (i=0;i<nivel;i++)
				printf("       ");
		printf("(%d-%c)--%d",padre, lado, arbol->dato);
		imprimirArbolBinario(arbol->izq,nivel+1,arbol->dato,'I');
	}
	return;
}

void preorden(AB *arbol){
	if (arbol){
		printf("-%i-",arbol->dato);
		preorden(arbol->izq);
		preorden(arbol->der);
	}
	return;
}

void inorden(AB *arbol){
	if (arbol){
		preorden(arbol->izq);
		printf("-%i-",arbol->dato);
		preorden(arbol->der);
	}
	return;
}

void postorden(AB *arbol){
	if (arbol){
		preorden(arbol->izq);
		preorden(arbol->der);
		printf("-%i-",arbol->dato);
	}
	return;
}

int imprimirMenu(void){
	int op = -1;
	system("cls");
	printf("******************************************\n");
	printf("*                 MENU                   *\n");
	printf("******************************************\n");
	printf("* 1.Crear ArbolBinario Manual            *\n");
	printf("* 2.Crear ArbolBinario Aleatorio         *\n");
	printf("* 3.                                     *\n");
	printf("* 4.                                     *\n");
	printf("* 5.                                     *\n");
	printf("* 6.                                     *\n");
	printf("* 7.                                     *\n");
	printf("* 8.Dibujar ArbolBinario en pantalla     *\n");
	printf("* 9.Ver ArbolBinario Post-In-PreOrden    *\n");
	printf("* 0.Salir                                *\n");
	printf("******************************************\n");
	printf("Digite su opción (0-9):\t"); 
	scanf("%i",&op);        
	return op;
}
