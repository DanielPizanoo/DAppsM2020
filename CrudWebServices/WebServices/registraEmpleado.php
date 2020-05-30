<?PHP
// Credenciales
$hostname_localhost="localhost";
$database_localhost="trabajadores";
$username_localhost="root";
$password_localhost="";

// Declaramos un array
$json=array();
 if(isset($_POST["clave"]) && isset($_POST["nombre"]) && isset($_POST["sueldo"])){
  $clave=$_POST['clave'];
  $nombre=$_POST['nombre'];
  $sueldo=$_POST['sueldo'];

   
  $conexion = new mysqli($hostname_localhost, $username_localhost, $password_localhost, $database_localhost);


  // Creamos cadena sql
  $insert="INSERT INTO empleados(clave, nombre, sueldo) VALUES ('{$clave}','{$nombre}','{$sueldo}')";
  
  //Intentamos ejecutar la cadena sql
  if($conexion->query($insert)===TRUE){
   
    // variable de consulta
     $resultado = $conexion->query("SELECT * FROM empleados WHERE clave = '{$clave}'");
   
  
   if($registro=mysqli_fetch_array($resultado)){
    $json['empleado'][]=$registro;
   }
   mysqli_close($conexion);
   echo json_encode($json);
   
  }else{
   $resulta["clave"]=0;
   $resulta["nombre"]="NO registrado";
   $resulta["sueldo"]="No registrado";
   $json['empleado'][]=$resulta;
   echo json_encode($json);
  }
 }else{
  $resulta["clave"]=0;
  $resulta["nombre"]="WS NO retorna";
  $resulta["sueldo"]="WS NO retorna";
  $json['empleado'][]=$resulta;
  echo json_encode($json);
 }
?>