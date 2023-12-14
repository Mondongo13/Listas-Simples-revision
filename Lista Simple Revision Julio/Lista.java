
public class Lista
{
   private Nodo top;//Debe de ser privado ya que no debe de poder acceder al objeto
  
     public Lista ()
     {//Constructor de la clase
      top = new Nodo();
      
    //Para agregar un nodo antes, debemos de usar un nodo temporal llamado temp
   }
   
   //Metodo para crear los nodos de la lista (agregar)
    public void add (int dato){
       Nodo temp = new Nodo();
     temp.dato = dato;
       if (top == null) {
         top = temp;
         return;
        }
        temp.next = top;
        top = temp;
    }
   
    //Metodo para mostrar la lista
    @Override //Indica que sobreescribiremos un metodo, el metodo de abajo del override, es el que sera sobreescrito al ya existente. Si no hicieramos esto, 
               //al momento de imprimir la lista, nos daria valores almacenados en memoria y no los que nosotros queremos
    public String toString ()
    {
        String S = ""; //Creamos una variable de tipo string y le asignamos un valor nulo
        Nodo temp = top; 
        while (temp.next !=null)
        {
          S += temp.dato + ", "; //Concatenamos 
          temp = temp.next;
        }
        return S; //S va a devolver todos los valores de la lista
    }
    

    
    //Metodo para buscar un nodo por el valor de su campo clave y devolver una referencia. (1)
     public Nodo buscar (int dato) 
     {   
      Nodo temp = top; //se crea temp y se le asigna  la cabeza
      while (temp != null) //recorrerá la lista hasta encontrar lo que se solicitó (dato)
      {
       if(temp.dato == dato) 
       {
        return temp;
       }
      temp = temp.next; //irá recorriendo toda la lista nodo por nodo
      }
        return temp; //devuelve el nodo temp si encontró el nodo buscado; sino, temp = null;
    }

    
    
    //Metodo para buscar un nodo por su campo clave e insertar un nuevo nodo después de él. (2)
    public void despuesDe (int buscar, int dato) throws Exception 
    {
        Nodo temp = new Nodo();
        temp.dato = dato;
        Nodo temp2 = this.buscar(buscar); //El this se sale del void y hace referencia a la clase, se reinicia y va de arriba hasta abajo
        if (temp2 == null) {
         throw new Exception ("No existe nodo a buscar :(");
        }
        
        temp.next = temp2.next;
        temp2.next = temp;
        }
        
    //Metodo para intercambiar un nodo por otro buscado(3)
    public void intercambio (int dato1, int dato2) 
    {
        Nodo temp1 = this.buscar(dato1);
        Nodo temp2 = this.buscar(dato2);
        int apoyo = temp1.dato; //Para intercambiar el valor de 2 variables, usamos una variable de apoyo que almacenara el valor de la primera variable para que esta no se pierda
        temp1.dato = temp2.dato; //Lo que esta en el 2 se va al 1, pero ya guardamos el valor de 1
        temp2.dato = apoyo; //el valor de 2 es el valor de 1 que previamente esta guardado en apoyo
    }
    
    
    }


    

  

