#  ConcessionaireManager
Manejo de clientes para agencia de concesionarios.

![Cat](https://github.com/nesmor/ConcessionaireManager/blob/master/src/main/webapp/assets/img/agency_dashboard.png)



## Arquitectura:  
 MVC basada en Spring Boot, utilizando para manejo de peticiones Web, el controlador MainController, para persistencia diferentes implementaciones de la interfaz JpaRepository. Acceso a base de datos a traves del API de persistencia de Java. 
 En la vista se implementaron plantillas .xhtml basadas en Primefaces.
 
 Se eligio la arquitectura MVC por temas de simplicidad para el Demo, sin embargo, se puede utilizar una arquitectura basada en microservicios Restfull.
 Para el layout se adapto la version gratuita de las plantilla ttps://demos.creative-tim.com/light-bootstrap-dashboard/  basadas en Bootstrap y HTML5.
 Se utilizo JUnit para pruebas unitarias sobre los metodos de la capa de persistencia.
 
##  Limitaciones:
 La integracion entre las plantillas y Primefaces, genero inconvenientes en la libreria javascript de Primefaces, probable incompatibilidad de versiones, lo que origino que se descarte el uso de los componentes como commandButtonpor por botones HTML y peticiones ajax.
 La falta de disponibilidad de tiempo para el desarrollo del demo por compromisos laborales, no permitio cubrir el avance completo del demo. 
 Preferencia de desarrollo del backend sobre frontend. 
 A lo largo de la experiencia profesional del desarrollador, ha utilizados frameworks como struts 1 y 2, ZK, GWT, para el desarrollo del frontend, se decidio implementar  PrimeFaces por temas de estandar en cuanto a JSF, lo que genero una curva de aprendizaje adicional.
 
##  Destrezas empleadas para el desarrollo del Demo. 

### Capa de acceso a datos:
- Diseno de modelo de datos.
- Generacion de Entidades con Mapeo necesario, validaciones a traves de BeanValidator, CascadeType dependiendo de la funcion, en el caso de la entidad Customer, limitando el mapeo del campo Agency de tipo Refresh.
-Implementacion de interfaz de acceso a datos de repositorios JpaRepository, y creacion de metodos adicionales segun el Standar de spring.
- Pruebas unitarias basadas en JUnit, para metodos de persistencia. 
-Implementacion de la clase logger para mensajes de la aplicacion. 
- Creacion de excepciones personalizadas. 

Limitaciones en capa de acceso a datos: i18 para cambios de lenguajes. Si la arquitectura se basa en microservicios, es necesario centralizar los mensajes para aplicaciones multilenguaje. 

### Capa Vista Controlador.
-Adaptabilidad a api desconocidas por el desarrollador (PrimeFaces). El proceso de adaptacion fue rapido debido a la similitud en cuanto al uso de otros frameworks como Struts.
-Conocimiento del lenguaje HTML5, CSS, Bootstrap, JS. Este conocimiento se puede apreciar crear el layout.html.El doctype asociado al documento es basado en xml y no en html, por lo que el etiquetado es estricto, para poder adaptar las plantillas es necesario comprender el uso de los esquemas y namespace xml. La idea era darle un aspecto profesional a las vistas, segun el requeriento de usabilidad y mejores practicas de desarrollo de interfaces. Se verifica el conocimiento de jquery, en la carga de los datos de los combos de ciudad y agencia, debido a que se utiliza la funcion $.ajax para solicitar la lista de agencias disponibles desde la base de datos, y dependiendo de la seleccion de la localidad, muestra la lista de agencias disponibles. 
-En el lado del controlador se envia la informacion en formato JSON y en la vista se crean los options dinamicamente con jquery.
-Capacidad de buscar un camino adicional en cuanto a inconvenientes en el camino original. Esta referencia se realiza por el inconveniente con la libreria js de Primefaces, que presento problemas de compatibilidad con la del diseno HTML. Luego de tratar de emplear el uso de los botones basados en el api de commandbutton, se decidio por cambiar a html button y a ajax para las peticiones. 

Limitantes en cuanto al frontend: Necesidad de sacar el texto a archivos i18 de traduccion. 







 
 
 
