package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {

    //Arreglo que guardará todos los libros 
    private List<Libro> listaLibros = new ArrayList<>();

    //Método que retorna todos los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    //Buscar libro por su id
    public Libro buscarPorId(int id){
        for(Libro libro: listaLibros){
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    //Buscar un libro por su isbn
    public Libro buscarPorIsbn(String isbn){
        for(Libro libro: listaLibros){
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    //Guarda un libro en el arreglo
    public Libro guardarLibro(Libro libro){
         listaLibros.add(libro);
         return libro;
         
    }

    //Actualiza el libro por el id
    public Libro actualizar(Libro libro){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == libro.getId()){
                id = libro.getId();
                idPosicion = i;

            }
        }
       

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(libro.getTitulo());
        libro1.setAutor(libro.getAutor());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setEditorial(libro.getEditorial());
        libro1.setIsbn(libro.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;


    }

     //Eliminar un libro por si id
     public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if(libro != null){
            listaLibros.remove(libro);
        }
    }
}
