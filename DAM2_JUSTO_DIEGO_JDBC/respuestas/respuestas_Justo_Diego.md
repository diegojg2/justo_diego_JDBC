PREGUNTA 1
Explica cómo funciona la relación 1:N entre Agencia y Satelite tanto en SQL como en Java.

-> La relacion es 1:N ya que una agencia puede tener muchos satelites pero un satelite solo puede pertenecer a una agencia, esto nos permite acceder a los datos de ambas tablas usando un inner join using (ID_AGENCIA), ya que al ser 
1:N ambas tablas tendrán el ID_AGENCIA, una Agencia como pk y Satelite como fk.


PREGUNTA 2
Explica por qué en Java utilizamos: private Agencia agencia; y no: private int agenciaId;

-> El pasarle directamente por parametro el objeto en vez de un atributo, nos permite acceder tambien directamente a todos los atributos de esa Agencia, y no solo a su id, lo que facilita las consultas. 


PREGUNTA 3
Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.

El PreparedStatement nos permite realizar consultas avanzadas sin tener que dar todos los detalles en los selects, permitiendo usar ? ? ? como puntos universales dentro del selecten el que después serán definidos a la hora de realizar la consulta.
Como por ejemplo en SELECT * FROM AGENCIA WHERE id = ?, que posteriormente se podrá reutilizar en casos como:
motorSQL.getPs().setString(1, agencia.getNombre());
motorSQL.getPs().setString(2, agencia.getPais());

