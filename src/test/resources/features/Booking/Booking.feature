# language: en
@Booking
Feature: Booking Category

  @RegressionTest
  Scenario: El usuario puede realizar una reserva en la aplicación de booking
    Given La aplicación de reservas se inicia
    When Se realiza la siguiente busqueda
      | {Destino} | {Fechas}                       | {Habitaciones} |{Adultos} | {Niños}| {edad} |
      | CUSCO     | 14 October 2022,28 October 2022| 1              | 2        | 1      | 16     |
      * Se selecciona el segundo resultado de la busqueda
      * Se selecciona la habitacion y se reserva la primera opcion
      * Se obtiene el precio de la reserva

    Then Se completa la información de la reserva
      | {Nombre}   | {Apellido} | {Correo}              | Direccion       |ZipCode| Ciudad |{Pais} | {Telefono}|
      | Alexander | Gamarra     | agamarrat@outlook.com | Vargas Prada 137|1530   | Lima   |Peru    | 980400686 |
      * Se verifica los datos de la reserva y se selecciona el ultimo paso

    Then Se elige la forma de pago tarjeta de credito
      | {Numero de Tarjeta}   | {Nombres}         | {exp.}|
      | 4555 7887 6544 3333   | Alexander Gamarra | 02/25 |
      And Se verifica el costo de la reserva despues del pago




