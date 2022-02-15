package com.lortega.birtlh.tareaaprendizaje3.bootstrap;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lortega.birtlh.tareaaprendizaje3.repositorios.modeloa.AddressRepositorioA;
import com.lortega.birtlh.tareaaprendizaje3.repositorios.modeloa.StudentRepositorioA;
import com.lortega.birtlh.tareaaprendizaje3.repositorios.modelob.StudentRepositorioB;
import com.lortega.birtlh.txuleta.repositorios.CategoriaRepositorio;
import com.lortega.birtlh.txuleta.repositorios.TxuletaRepositorio;

import entidades.Address;
import entidades.Student;

@Component 
public class BootStrapData implements CommandLineRunner {

	private static Logger log = LoggerFactory
		      .getLogger(BootStrapData.class);
	
	
	@Autowired
	private AddressRepositorioA addressRepositorioA;
	
	@Autowired
	private StudentRepositorioA studentRepositorioA;
	
	@Autowired
	private StudentRepositorioB studentRepositorioB;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("START Tarea Aprendizaje3");
		log.info("END Tarea Aprendizaje3");
	}
	
	@Transactional
	private void tareaAprendizaje3AEjercicio1() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3A Ejercicio1");
		log.info("------------------------------------------");
		log.info("Creando un nuevo objeto Student con su dirección...");
		com.lortega.birtlh.tareaaprendizaje3.modeloa.Student student = createStudentModeloA();	
				
		studentRepositorioA.save(student);
		
		log.info("Hecho!");

		log.info("END tareaAprendizaje3A Ejercicio1");

	}
	
	@Transactional
	private void tareaAprendizaje3AEjercicio4() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3A Ejercicio4");
		log.info("------------------------------------------");
		log.info("Borrando un objeto Student");
		
		int student_id = 172;
		
		com.lortega.birtlh.tareaaprendizaje3.modeloa.Student tempStudent = studentRepositorioA.getById(student_id);
	
		studentRepositorioA.delete(tempStudent);
		
		log.info("Hecho!");

		log.info("END tareaAprendizaje3A Ejercicio4");

	}
	
	
	@Transactional
	private void tareaAprendizaje3BEjercicio1() throws Exception {
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3B Ejercicio1");
		log.info("------------------------------------------");
		
		log.info("Creando un nuevo objeto Student con su dirección...");
		com.lortega.birtlh.tareaaprendizaje3.modelob.Student student = createStudentModeloB();
		
		// guarda el objeto Student
		log.info("Guardando el estudiante...");
		studentRepositorioB.save(student);
				
		System.out.println("Hecho!");
		
		log.info("END tareaAprendizaje3B Ejercicio1");
	}

	
	@Transactional
	private void tareaAprendizaje3BEjercicio4() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3B Ejercicio4");
		log.info("------------------------------------------");
	
		// crea un objeto Student
		log.info("Borrando un objeto Student y sus teléfonos");
					
		int student_id = 176;
					
		com.lortega.birtlh.tareaaprendizaje3.modelob.Student tempStudent = studentRepositorioB.getById(student_id);
							
		studentRepositorioB.delete(tempStudent);
							
		log.info("Hecho!");
		
		log.info("END tareaAprendizaje3B Ejercicio4");
		
	}

	
	@Transactional
	private void tareaAprendizaje3CEjercicio1() throws Exception {
		
	}
	

	@Transactional
	private void tareaAprendizaje3CEjercicio4() throws Exception {
		
	}

	
	private static com.lortega.birtlh.tareaaprendizaje3.modeloa.Student createStudentModeloA() {
		com.lortega.birtlh.tareaaprendizaje3.modeloa.Student tempStudent = new com.lortega.birtlh.tareaaprendizaje3.modeloa.Student();
		com.lortega.birtlh.tareaaprendizaje3.modeloa.Address tempAddress = new com.lortega.birtlh.tareaaprendizaje3.modeloa.Address();
		tempStudent.setFirstName("Gorka");
		tempStudent.setLastName("Unamuno");
		tempStudent.setEmail("gunamuno@birt.eus");
		tempAddress.setAddressLine1("Kale Nagusia 10");
		tempAddress.setAddressLine2("3B");
		tempAddress.setCity("Donostia");
		tempAddress.setZipCode("20003");
		tempStudent.setAddress(tempAddress);
		return tempStudent;		
	}
	
	
	private static com.lortega.birtlh.tareaaprendizaje3.modelob.Student createStudentModeloB() {
		com.lortega.birtlh.tareaaprendizaje3.modelob.Student tempStudent = new com.lortega.birtlh.tareaaprendizaje3.modelob.Student();
		com.lortega.birtlh.tareaaprendizaje3.modelob.Address tempAddress = new com.lortega.birtlh.tareaaprendizaje3.modelob.Address();
		tempStudent.setFirstName("Mikel");
		tempStudent.setLastName("Unamuno");
		tempStudent.setEmail("junamuno@birt.eus");
		tempStudent.getPhones().add("712123456");
		tempStudent.getPhones().add("712123457");
		tempAddress.setAddressLine1("Kale Nagusia 10");
		tempAddress.setAddressLine2("3B");
		tempAddress.setCity("Donostia");
		tempAddress.setZipCode("20003");
		tempStudent.setAddress(tempAddress);
		return tempStudent;		
	}
}
