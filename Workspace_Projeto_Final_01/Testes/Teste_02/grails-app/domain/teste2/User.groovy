package teste2

class User{
   String name
   byte[] avatar
    
   static constraints = {
       avatar(size:0..131072, nulable: true)
   }
}