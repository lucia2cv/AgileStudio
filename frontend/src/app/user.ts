export class User {
  id: number;
  nombre: string;
  password: string
  email: string
  rol: string
  equipo:string;
  //id_equipo: number;

  constructor(nombre: string, password: string, email: string, rol: string, equipo:string) {
    //this.id = id;
    this.nombre = nombre;
    this.password = password;
    this.email = email;
    this.rol = rol;
    this.equipo = equipo;
    //this.id_equipo = id_equipo;
  }
  imprimir(){
    console.log('nombre: ' + this.nombre);
    console.log('contrasena: ' + this.password);
    console.log('email: ' + this.email);
    console.log('rol: ' + this.rol);
    console.log('Equipo: ' + this.equipo);
  }
}
