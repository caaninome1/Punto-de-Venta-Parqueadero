# Punto-de-Venta-Parqueadero
POS(Point of Sale) para la administración de parqueaderos, desarrollado en JAVA Netbeans v8.2 con persistencia de datos JPA, Java Swing.

Se recomienda usar dicha versión de Netbeans (v8.2) junto con jdk1.8.0_111, dado que se presentan conflictos con nuevas versiones.
Como prueba en el proyecto, se usa Java Persistence API (JPA) más precisamente EclipseLink (JPA 2.1), más adelante se subirá un nuevo repositorio con cambios como por ejemplo la conexión con otros sistemas de bases de datos, se realizarán mejoras en la generación de informes etc.
¿Cómo ejecutar el proyecto?

Descargar la carpeta del repositorio, descomprimirla y guardarla en la carpeta local por defecto (NetbeansProjects) o donde haya seleccionado la ruta de almacenamiento de sus proyectos. Otra alternativa es abrir directamente Netbeans v8.2 y clonar directamente el repositorio.

Abrir Netbeans, -File-Open Project y seleccionar la carpeta descomprimida (Este paso no es necesario si se realizó la clonación del repositorio)

Al realizar lo anterior, observará que el proyecto arroja bastantes errores, esto es porque no se hán agregado algunas de las librerías, para ello, subiré una carpeta llamada "lib" con las librerías necesarias.(Ver tutoriales en Youtube o buscar información en la red de cómo agregar librerias en Netbeans)

Después de que se cargen las librerías, los mensajes de error se deben eliminar automáticamente, en caso de que eso no ocurra, seleccionar la raíz principal del proyecto "Parqueadero_v2.5", dar click derecho y seleccionar "Clean and Build" esto reconstruirá el proyecto con las librerías recientemente agregadas.

Antes de ejecutar el proyecto, debe realizar la conexión a los servicios de bases de datos JPA, para esto, lo primero que debe hacer es buscar en el despliegue del proyecto "Parqueadero_v2.5" la carpeta "META-INF" allí se encuentra almacenada la información de la conexión a la base de datos, junto con datos de usuario y contraseña, en este caso en concreto el user es "administrador" y la password "1234". Mi consejo es que elimine esta carpeta dando click derecho y seleccionando "delete". Seguidamente debe dirigirse a la ventana "Services" generalmente se encuentra anclada al lado de la ventana "Projects" en caso de que no la encuentre, seleccionar en el menú superior la opción "Window" dar click "Services", esto le debería abrir dicha ventana. Después de que se encuentre ubicado en esta ventana. debe desplegar "Databases" dar click derecho en "Java DB" y seleccionar "Create Database..." esto le abrirá una ventana emergente en donde debe darle un nombre a su base de datos, por ejemplo "Parqueadero" , y escribir un nuevo nombre de usuario y password, en mi caso yo escribí los que mencioné anteriormente "administrador" "1234" confirman la contraseña y verifican que la ubicación de la base de datos sea "C:\Users\Admin\AppData\Roaming\NetBeans\Derby" o una ruta similar, lo importante es que se encuentre dentro de la carpeta Derby, de no ser así, verificar que tengan agregada la librería Persistence(JPA 2.1) - javax.persistence_2.1.0..... o la librería Java DB Driver -derby.jar si no tienen problema, finalizar dando click en "OK", esto debería crearles automáticamente la carpeta eliminada previamente pero con sus datos de usuario y contraseña "META-INF". Ahora bien en la ventana services al desplegar "Java DB" debería aparecer la nueva base de datos asociada al nombre que le dieron, dar click derecho y seleccionar "Connect" esto conectara su base de datos y a su vez, desplegará una carpeta llamada "Drivers" e internamente debe encontrarse algo similar a jdbc:derby://localhost:1527/Parqueadero [administrador on ADMINISTRADOR], allí es donde encontrarán toda la información almacenada en su base de datos, que por el momento debe estar vacía dado que aún no se ha ejecutado el proyecto.

Después de haber realizado los pasos anteriores, ya está listo para empezar a ejecutar el proyecto, para esto, diríjase a la ventana Projects y dentro de "Parqueadero_v2.5" desplegar la carpeta "FRONTERA" aquí se encuentra todo el manejo de las ventanas que interactúan con el usuario final, puede seleccionar "FramePrincipal.java" click derecho y seleccionar "Run file" inmediatamente se ejecutará la ventana principal del gestor de parqueaderos y podrá crear su primer parqueadero con información personalizada del nombre del parqueadero o razón social, nit, teléfono, dirección, tarifas para los vehículos entre otras cosas, también podrá asignar operarios o personas encargadas de registrar la entrada y salida de los vehículos. Intentaré adjuntar un video detallado en donde explique el funcionamiento completo de este sistema.
