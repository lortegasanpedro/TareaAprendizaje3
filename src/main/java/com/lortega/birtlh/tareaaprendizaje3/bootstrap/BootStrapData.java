package com.lortega.birtlh.tareaaprendizaje3.bootstrap;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lortega.birtlh.tareaaprendizaje3.modelo.Address;
import com.lortega.birtlh.tareaaprendizaje3.modelo.Student;
import com.lortega.birtlh.tareaaprendizaje3.repositorios.StudentRepositorio;




@Component 
public class BootStrapData implements CommandLineRunner {

	private static Logger log = LoggerFactory
		      .getLogger(BootStrapData.class);
	
		
	//@Autowired
	//private com.lortega.birtlh.tareaaprendizaje3.repositorios.modeloa.StudentRepositorioA studentRepositorioA;
	
	//@Autowired
	//private com.lortega.birtlh.tareaaprendizaje3.repositorios.modelob.StudentRepositorioB studentRepositorioB;
	
	@Autowired
	private StudentRepositorio studentRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("START Tarea Aprendizaje3");
		this.tareaAprendizaje3AEjercicio1();
		this.tareaAprendizaje3AEjercicio4();
		this.tareaAprendizaje3BEjercicio1();
		this.tareaAprendizaje3BEjercicio4();
		this.tareaAprendizaje3CEjercicio1();
		this.tareaAprendizaje3CEjercicio4();
		log.info("END Tarea Aprendizaje3");
	}
	
	@Transactional
	private void tareaAprendizaje3AEjercicio1() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3A Ejercicio1");
		log.info("------------------------------------------");
		log.info("Creando un nuevo objeto Student con su dirección...");
		Student student = createStudentModeloA();	
				
		studentRepositorio.save(student);
		
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
		
		if (studentRepositorio.existsById(student_id)) {
			Student tempStudent = studentRepositorio.getById(student_id);
			studentRepositorio.delete(tempStudent);
			log.info("Hecho!");
		} else {
			log.info("NO encontrado!");
		}
		
		
		log.info("END tareaAprendizaje3A Ejercicio4");

	}
	
	
	@Transactional
	private void tareaAprendizaje3BEjercicio1() throws Exception {
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3B Ejercicio1");
		log.info("------------------------------------------");
		
		log.info("Creando un nuevo objeto Student con su dirección...");
		Student student = createStudentModeloB();
		
		// guarda el objeto Student
		log.info("Guardando el estudiante...");
		studentRepositorio.save(student);
				
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
		
		if (studentRepositorio.existsById(student_id)) {
			Student tempStudent = studentRepositorio.getById(student_id);
			studentRepositorio.delete(tempStudent);					
			log.info("Hecho!");
		} else {
			log.info("NO encontrado!");
		}
		
		log.info("END tareaAprendizaje3B Ejercicio4");
		
	}

	
	
	@Transactional
	private void tareaAprendizaje3CEjercicio1() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3C Ejercicio1");
		log.info("------------------------------------------");

		// crea un objeto Student
		log.info("Creando un nuevo objeto Student con su dirección...");
		com.lortega.birtlh.tareaaprendizaje3.modelo.Student student = createStudentModeloC();	
							
					
		// guarda el objeto Student
		log.info("Guardando el estudiante...");
		studentRepositorio.save(student);
								
		// es necesario refresh para hacer una select y así obtener el valor del campo calculado
		//studentRepositorioC.rrefresh(student);
		log.info(String.valueOf(student.getAge()));
					
		log.info("Hecho!");
		
		log.info("END tareaAprendizaje3C Ejercicio1");
	}

	@Transactional
	private void tareaAprendizaje3CEjercicio4() throws Exception {
		
		log.info("------------------------------------------");
		log.info("tareaAprendizaje3C Ejercicio4");
		log.info("------------------------------------------");

		
		System.out.println("Borrando un objeto Student y sus teléfonos");
		
		int student_id = 9;
		
		if (studentRepositorio.existsById(student_id)) {
			Student tempStudent = studentRepositorio.getById(student_id);
			studentRepositorio.delete(tempStudent);					
			log.info("Hecho!");
		} else {
			log.info("NO encontrado!");
		}
		
		log.info("END tareaAprendizaje3C Ejercicio4");

	}
	
	private static Student createStudentModeloA() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
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
	
	private static Student createStudentModeloB() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
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
	
	private static Student createStudentModeloC() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
		tempStudent.setFirstName("Mikel");
		tempStudent.setLastName("Unamuno");
		tempStudent.setEmail("gunamuno@birt.eus");
		tempStudent.getPhones().add("612123456");
		tempStudent.getPhones().add("612123457");
		tempStudent.setBirthdate(LocalDate.parse("1989-04-04"));
		tempAddress.setAddressLine1("Kale Nagusia 10");
		tempAddress.setAddressLine2("3B");
		tempAddress.setCity("Donostia");
		tempAddress.setZipCode("20003");
		tempStudent.setAddress(tempAddress);
		return tempStudent;		
	}
	
}
