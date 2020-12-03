export class User {
  id: number;
  nombre: string;
  password: string
  email: string
  rol: string
  //id_equipo: number;

  constructor(id: number, nombre: string, password: string, email: string, rol: string) {
    this.id = id;
    this.nombre = nombre;
    this.password = password;
    this.email = email;
    this.rol = rol;
    //this.id_equipo = id_equipo;
  }
}
