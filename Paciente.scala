import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn._

class Prueba(private var _nombre:String="ND", private var _primerAp:String="ND", 
  private var _segundoAp:String="ND",private var _edad:Byte=0, private var _fecha:Array[String], 
  private var _horaRegistro:Array[Int], private var _nivelBienestar:Array[Int], 
  private var _temperatura:Array[Int], private var _humedad:Array[String]) {
  
  def nombre=_nombre
  def primerAp=_primerAp
  def segundoAp=_segundoAp
  def edad=_edad
  
  def fecha=_fecha
  def horaRegistro=_horaRegistro
  def nivelBienestar=_nivelBienestar
  def temperatura=_temperatura
  def humedad=_humedad
     
  def nombre_=(nombre:String):Unit={
    _nombre=nombre
  }
  
  def primerAp_=(primerAp:String):Unit={
    _primerAp=primerAp
  }
  
  def segundoAp_=(segundoAp:String):Unit={
    _segundoAp=segundoAp
  }
  
  def edad_=(edad:Byte):Unit={
    _edad=edad
  }
  
  def fecha_=(fecha:Array[String]):Unit={
    _fecha=fecha
  }
  
  def horaRegistro_=(horaRegistro:Array[Int]):Unit={
    _horaRegistro=horaRegistro
  }
  
  def nivelBienestar_=(nivelBienestar:Array[Int]):Unit={
    _nivelBienestar=nivelBienestar
  }
  
  def temperatura_=(temperatura:Array[Int]):Unit={
    _temperatura=temperatura
  }
  
  def humedad_=(humedad:Array[String]):Unit={
    _humedad=humedad
  }
      
  def promedioBienestar():Unit={
    var suma:Double=0.0
    for(x<-0 until nivelBienestar.length){
      suma+=nivelBienestar(x)
    }
    println("Promedio de Bienestar: " + suma/nivelBienestar.length)
    println("-----------------------------------------------------")
  }
  
  def obtenerTemperaturaMayor():Unit={
    var temp=0
    var cont=0
    for(x<-0 until temperatura.length){
      if(x==0){
        temp=temperatura(x)
        cont=x
      }else if(temp<temperatura(x)){
         temp=temperatura(x)
         cont=x
      }        
    }
    
    println("Temperatura MAYOR registrada: "+temp+"\nFecha: "+fecha(cont)+"\nHora de registro: "+
        horaRegistro(cont)+"\nNivel de bienestar registrado: "+nivelBienestar(cont)+"\nHumedad: "+
        humedad(cont))
    println("-----------------------------------------------------")
  }
  
  def obtenerTemperaturaMenor():Unit={
    var temp=0
    var cont=0
    for(x<-0 until temperatura.length){
      if(x==0){
        temp=temperatura(x)
        cont=x
      }else if(temp>temperatura(x)){
         temp=temperatura(x)
         cont=x
      }        
    }
    
    println("Temperatura MENOR registrada: "+temp+"\nFecha: "+fecha(cont)+"\nHora de registro: "+
        horaRegistro(cont)+"\nNivel de bienestar registrado: "+nivelBienestar(cont)+"\nHumedad: "+
        humedad(cont))
    println("-----------------------------------------------------")
  }
}

object Paciente{
  def main(args: Array[String]): Unit = {
    println("===================MONITOREO PACIENTE===================")
    
    val nombre = "Luis Gerardo"
    val primerAp ="Dorado"
    val segundoAp ="Rosales"
    val edad:Byte=23
    
    val fecha=Array[String]("21-05-2019", "23-10-2019", "04-11-2019","31-12-2019")
    val horaRegistro=Array[Int](22, 23, 4, 18)
    val nivelBienestar=Array[Int](2, 5, 4, 4)
    val temperatura=Array[Int](37, 35, 33, 34)
    val humedad=Array[String]("37%", "35%", "33%", "34%")
       
    val obj=new Prueba(nombre, primerAp, segundoAp, edad, fecha, horaRegistro, nivelBienestar, temperatura, humedad) 
    
    var opcion:String="";
    do{
      println("Que es lo que desea realizar: ")
      println("(1) - Obtener promedio del nivel de bienestar")
      println("(2) - Obtener temperatura mayor")
      println("(3) - Obtener temperatura menor")
      println("(4) - Salir")
      opcion=readLine()
      
      opcion match {
        case "1" => obj.promedioBienestar()
        case "2" => obj.obtenerTemperaturaMayor()
        case "3" => obj.obtenerTemperaturaMenor()
        case _=>    println("�Opci�n incorrecta!")
      }
    }while(!opcion.equals("4"))  
  }  
}
