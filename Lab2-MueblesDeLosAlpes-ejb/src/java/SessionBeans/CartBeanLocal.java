/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import com.losalpes.bos.Carrito;
import com.losalpes.bos.Item;
import com.losalpes.bos.Orden;
import javax.ejb.CreateException;
import javax.ejb.Local;

/**
 *
 * @author Kurush
 */
@Local
public interface CartBeanLocal {

    Carrito anadirItemCarrito(Carrito carrito, Item item);

    Carrito quitarItemCarrito(Carrito carrito, int numeroItem);

    Carrito crearCarrito(String nombreUsuario);

    Orden crearOrden(Carrito carrito);
    
}
