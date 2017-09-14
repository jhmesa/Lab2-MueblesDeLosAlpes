/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import com.losalpes.bos.Carrito;
import com.losalpes.bos.Item;
import com.losalpes.bos.Orden;
import java.util.Random;
import javax.ejb.Stateful;

/**
 *
 * @author Kurush
 */
@Stateful
public class CartBean implements CartBeanLocal {

    
    /*
    *@return el carrito con el nuevo item anadido
    *@param carrito, item 
    */
    @Override
    public Carrito anadirItemCarrito(Carrito carrito,Item item) {
        carrito.addItem(item);               
        return carrito;
    }
    
    
    /*
    *@return el carrito sin el item que se queria remover
    *@param carrito, numeroItem
    */

    @Override
    public Carrito quitarItemCarrito(Carrito carrito, int numeroItem) {        
        carrito.removeItem(numeroItem);
        return carrito;
    }
    
    /*
    *@return un carrito vacio
    *@param nombreUsuario dueno del carrito
    */
    @Override
    public Carrito crearCarrito(String nombreUsuario) {
        Carrito nuevoCarrito = new Carrito();
        nuevoCarrito.setNombreUsuario(nombreUsuario);        
        return nuevoCarrito;
    }

    /*
    *@return un carrito vacio
    *@param nombreUsuario dueno del carrito
    */
    @Override
    public Orden crearOrden(Carrito carrito) {
        Random rand = new Random();
        String idOrden;
        idOrden = String.valueOf(rand.nextInt());
        Orden nuevaOrden;
        nuevaOrden = new Orden(carrito.getNombreUsuario(), idOrden, carrito.getItems());
        return nuevaOrden;
    }
    
    


}
