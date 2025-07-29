# Registro de exportaciones 
Manejo de logistica para una empresa de envios

## Datos que se deben solicitar al usuario:
 - ID cliente: Este dato corresponde a la cédula de identificación del usuario, según el formato de
      Costa Rica: 1-1111-1111.
 - Nombre completo: Este dato debe contener al menos 7 caracteres.
 - Tipo de Exportación: Este dato debe ser una nomenclatura de únicamente 3 caracteres
      ( Exportación Carga Pesada = ECP, Exportación Carga Suelta = ECS).
 - Fecha de exportación: Este dato no debe ser solicitado al usuario, debe ser obtenido
         dependiendo del día que se ejecute el sistema.
 - Zona de envío: País de envío.
 - Tipo de Servicio: Barco o Avión.
 - Kilogramos a embalar: Dato digitado por el usuario.
 - Costo por cada exportación aprobada: El sistema debe realizar el cálculo de la exportación.

### Requerimientos adicionales:
• Crear un programa que permita administrar datos de las exportaciones en un archivo
llamado Exportaciones.dat. Esta administración incluye agregar, actualizar y borrar datos.
• Heredar de la clase Exportación para crear clases especializadas que puedan calcular los costos
de los nuevos tipos de servicios según los siguientes atributos y mejoras en los métodos:
Exportación Carga Pesada:
• Atributos adicionales: Tipo de Carga (Contenedor Refrigerado, Contenedor no
refrigerado y Carga embalada).
Exportación Carga Suelta:
• Atributos adicionales: Pies de la carga.
Métodos nuevos o mejorados:
• CalcularExportación:
• El costo por kilogramo de Exportación Carga Pesada cambia según estos nuevos
valores: Contenedor Refrigerado ($950 x Kilo), Contenedor no refrigerado ($550
x Kilo) y Carga embalada ($450 x Kilo) solo para cargas por barco.
• Exportación Carga Suelta mantiene los precios establecidos ($450 por kilo en
avión y $150 por kilo en barco), pero si la carga supera los 18 pies y es por avión,
tiene un adicional de $100; si es por barco, el adicional es de $50

## Interfaz grafica con Swin UI

