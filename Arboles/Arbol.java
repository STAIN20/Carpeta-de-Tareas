/**
 * Clase principal Arbol
 */
public class Arbol <T> {                    
  private NodoArbol <T> raiz;             
  private boolean esBinario = false;    
  boolean estaVacio = false;  

  /**
   * Constructor para inicializar el nodo raiz con el dato proporcionado y checa si es un arbol binario o no
   * @param dato
   * @param esBinario                         
   */
  public Arbol (T dato, boolean esBinario) {
    raiz = new NodoArbol <T> (dato);             
    raiz.setEsBinario(esBinario);                 
    this.esBinario = esBinario;
  }

  /**
   * Método que nos retornará el nodo raíz
   * @return
   */
  public NodoArbol <T> obtenerRaiz() {
    return raiz;                           
  }

  /**
   * Este booleano nos verifica y retorna un "True" o "False" en caso de ser o no un arbol binario
   * @return
   */
  public boolean esBinario() {            
    return esBinario;                     
  }

  /**
   * Este metodo agrega un nodo (hijo) al arbol y se le agrega la propiedad de esBinario y lo toma como nodo hijo
   * @param nodoRaiz
   * @param nodoAgregado
   */
  public void agregarNodoArbol(NodoArbol <T> nodoRaiz, NodoArbol <T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);                  
    }                                                         

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * Este metodo imprime el arbol de 3 diferentes ordenes de recorrido dependiendo del valor de "recorrido"
   * Ordenes: Prefijo, infijo y posfijo
   * @param recorrido
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");         
        raiz.imprimirEnPrefijo();                      
        break;                                          

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;
    
      default:
        break;
    }
  }

  /**
   * Método para la impresion del subarbol a partir de cierto nodo dependiendo del arbol
   * en cada uno de los tipos de recorrido
   * @param nodoSubArbol
   */
  public void imprimirSubArbol(NodoArbol<T> nodoSubArbol) {
    System.out.println("Impresión en Prefijo: ");
    nodoSubArbol.imprimirEnPrefijo();
    System.out.println();

    System.out.println("Impresión en Infijo: ");
    nodoSubArbol.imprimirEnInfijo();
    System.out.println();

    System.out.println("Impresión en Posfijo");
    nodoSubArbol.imprimirEnPosfijo();

  }
  
  /**
   * Booleano que nos retornará la comprobacion del estado del arbol, si esta vacio o no
   * @return
   */
  public boolean estaVacio() {
    return estaVacio;
  }

  /**
   * Metodo que nos retornara la altura obtenida del arbol correspondiente
   * @return
   */
  public int obtenerAltura() {
    return obtenerAltura(raiz);
  }

  /**
   * Logica detras del metodo obtener altura, utilizando un is que comprueba la existencia de un nodo,
   * así un else que nos dara la altura con ayuda de los nodos hijos y hermanos y se le sumara 1 por el 
   * nodo raiz
   * @param nodo
   * @return
   */
  private int obtenerAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      int altura = 0;
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        altura = Math.max(altura, obtenerAltura(hijo));
        hijo = hijo.obtenerSiguienteHermano();
      }
      return altura + 1;
    }
  }
}