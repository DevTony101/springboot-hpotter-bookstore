package com.hpotter.bookstore.services;

import com.hpotter.bookstore.entities.Book;
import com.hpotter.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IBookService implements BookService {

    private final BookRepository repository;

    IBookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(this.repository.findAll());
    }

    @Override
    public Book getOne(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Long id, Book newBook) {
        return this.repository.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setPrice(newBook.getPrice());
            book.setQuantity(newBook.getQuantity());
            book.setCover(newBook.getCover());
            return repository.save(book);
        }).orElse(null);
    }

    @Override
    public void createRecords() {
        Book book = null;
        if (this.repository.findAll().size() == 0) {
            book = new Book();
            book.setTitle("Harry Potter y la Piedra Filosofal");
            book.setDescription("Harry vive con sus horribles tíos y el insoportable primo Dudley, hasta que su ingreso en el Colegio Hogwarts de Magia y Hechicería cambia su vida para siempre. Allí aprenderá trucos y encantamientos fabulosos, y hará un puñado de buenos amigos... aunque también algunos temibles enemigos. Y, sobre todo, conocerá los secretos que lo ayudarán a cumplir con su destino.");
            book.setQuantity("44");
            book.setPrice("58000");
            book.setCover("https://m.media-amazon.com/images/I/517DxWbJNZL._SY346_.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y la Cámara Secreta");
            book.setDescription("Mientras Harry espera impaciente en casa de sus insoportables tíos el inicio del segundo curso del Colegio Hogwarts de Magia y Hechicería, un elfo aparece en su habitación y le advierte de que una amenaza mortal se cierne sobre la escuela. Harry no se lo piensa dos veces y, acompañado de Ron, se dirige a Hogwarts en un coche volador. Allí, Harry oye extraños susurros en los pasillos desiertos y, de pronto... los ataques comienzan. La siniestra predicción del elfo parece hacerse realidad.");
            book.setQuantity("67");
            book.setPrice("75100");
            book.setCover("https://m.media-amazon.com/images/I/515J1emcbkL.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y el Prisionero de Azkaban");
            book.setDescription("De la prisión de Azkaban se ha escapado un terrible villano, Sirius Black, un asesino en serie que fue cómplice de lord Voldemort y que, dicen los rumores, quiere vengarse de Harry por haber destruido a su maestro. Por si esto fuera poco, entran en acción los dementores, unos seres abominables capaces de robarles la felicidad a los magos y de eliminar todo recuerdo hermoso de aquellos que se atreven a acercárseles. El desafío es enorme, pero Harry, Ron y Hermione son capaces de enfrentarse a todo esto y mucho más.");
            book.setQuantity("18");
            book.setPrice("24100");
            book.setCover("https://m.media-amazon.com/images/I/41zqI6oPb-L._SY346_.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y el Cáliz de Fuego");
            book.setDescription("Otro deplorable verano con los Dursley llega a su fin y Harry está impaciente por regresar a Hogwarts. A sus catorce años, sólo desea ser un joven mago como los demás y dedicarse a aprender nuevos sortilegios y asistir a los Mundiales de quidditch. Sin embargo, en Hogwarts le espera un desafío de grandes proporciones, por lo que tendrá que demostrar que ya no es un niño y que está preparado para vivir las nuevas y emocionantes experiencias que el futuro le depara.");
            book.setQuantity("87");
            book.setPrice("62000");
            book.setCover("https://m.media-amazon.com/images/I/51Y6Exe5UiL._SY346_.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y la Orden del Fénix");
            book.setDescription("Las vacaciones de verano aún no han acabado y Harry se encuentra más inquieto que nunca. Apenas ha tenido noticias de Ron y Hermione, y presiente que algo extraño está sucediendo en Hogwarts. No bien empieza el nuevo curso, sus temores se vuelven realidad: el Ministerio de Magia ha iniciado una campaña de desprestigio contra él y Dumbledore, para lo cual ha asignado a la horrible profesora Dolores Umbridge la tarea de vigilar sus movimientos. Y por si fuera poco, Harry sospecha que Voldemort es capaz de adivinar sus pensamientos con el fin de apoderarse de un objeto secreto que le permitiría recuperar su poder destructivo.");
            book.setQuantity("97");
            book.setPrice("42800");
            book.setCover("https://m.media-amazon.com/images/I/41q-WZgFyBL.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y el Misterio del Príncipe");
            book.setDescription("En medio de graves acontecimientos que asolan el país, Harry inicia su sexto curso en Hogwarts. El equipo de quidditch, los exámenes y las chicas lo mantienen ocupado, pero la tranquilidad dura poco. A pesar de los férreos controles de seguridad, dos alumnos son brutalmente atacados. Dumbledore sabe que, tal como se anunciaba en la Profecía, Harry y Voldemort han de enfrentarse a muerte. Así pues, para intentar debilitar al enemigo, el anciano director y el joven mago emprenderán juntos un peligroso viaje con la ayuda de un viejo libro de pociones perteneciente a un misterioso personaje, alguien que se hace llamar Príncipe Mestizo.");
            book.setQuantity("45");
            book.setPrice("38800");
            book.setCover("https://m.media-amazon.com/images/I/51WLWaAEBkL.jpg");
            this.repository.save(book);

            book = new Book();
            book.setTitle("Harry Potter y las Reliquias de la Muerte");
            book.setDescription("La fecha crucial se acerca. Cuando cumpla los diecisiete, Harry perderá el encantamiento protector que lo mantiene a salvo. El anunciado combate a muerte con Voldemort es inminente, y la casi imposible misión de encontrar y destruir los Horrocruxes restantes es más urgente que nunca. Ha llegado el momento de tomar las decisiones más difíciles. Harry debe abandonar la calidez y seguridad de La Madriguera para emprender sin miedo ni vacilaciones el inexorable sendero trazado para él. Consciente de lo mucho que está en juego, sólo dentro de sí mismo encontrará la fuerza que lo impulsará en la vertiginosa carrera hacia un destino desconocido.");
            book.setQuantity("62");
            book.setPrice("91500");
            book.setCover("https://m.media-amazon.com/images/I/512gF89kp2L.jpg");
            this.repository.save(book);
        }
    }
}
