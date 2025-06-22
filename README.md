# 📚 Literalura

Literalura es una aplicación de consola desarrollada en Java con Spring Boot que permite construir un catálogo de libros consultando datos desde la API de [Gutendex](https://gutendex.com/). 
Los datos se almacenan en una base de datos PostgreSQL y el usuario puede realizar diversas consultas desde un menú interactivo.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- API Gutendex
- Jackson (para manejar JSON)
- HttpClient (para consumir la API)
- PgAdmin4 para crear la base de datos

---

## 📌 Funcionalidades del menú

Vista del menú en consola:

✦✦✦ Catálogo de Libros - Literalura ✦✦✦
1 - Buscar libros por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Lista de autores vivos en un año determinado
5 - Lista de libros por idioma
6 - Buscar autores por nombre
7 - Top 10 de libros más descargados
8 - Salir
Selecciona una opción:

---

## 🧠 Qué hace cada opción

1. **Buscar libros por título**  
   Busca el libro en Gutendex y lo guarda en la base de datos junto con su autor.

2. **Listar libros registrados**  
   Muestra todos los libros guardados localmente.

3. **Listar autores registrados**  
   Lista todos los autores de libros registrados.

4. **Autores vivos en un año determinado**  
   Permite ingresar un año y muestra los autores que estaban vivos en ese momento.

5. **Listar libros por idioma**  
   Filtra libros registrados por idioma (por código, como `en`, `es`, etc.).

6. **Buscar autores por nombre**  
   Busca autores que contengan el texto ingresado, sin importar mayúsculas/minúsculas.

7. **Top 10 libros más descargados**  
   Ordena y muestra los 10 libros con más descargas.

8. **Salir**  
   Finaliza el programa.

---

## 📸 Vistas del Programa en Ejecución

### 🧭 Menú principal
![Menú principal](https://raw.githubusercontent.com/Mei967/LiterAlura/main/menu-inicio.png)

### Lista de autores registrados
![Lista autores]

### Libros por idioma
[Vista de libros por idioma](https://github.com/Mei967/LiterAlura/raw/main/libros-por-idioma.png)






## 🗃️ Estructura del proyecto

aluracursos.literalura
│
├── model → Entidades: Libro, Autor
├── repository → Interfaces JPA: LibroRepository, AutorRepository
├── service → Consumo de API y conversión: ConsumoAPI, ConversorDeDatos
├── dto → Clases para mapear el JSON de Gutendex
├── principal → Clase Principal con el menú y lógica del programa
└── LiteraluraApplication.java → Clase main que arranca Spring Boot



---

💡 Nota
Este proyecto fue desarrollado paso a paso para aprender sobre:

Uso de APIs públicas

Estructuración de proyectos en Java con Spring Boot

Manejo de base de datos con JPA

Consola interactiva con Scanner

✨ Autor
Proyecto realizado por Meiby como parte del aprendizaje en backend Java con Alura + Spring Boot 🚀
