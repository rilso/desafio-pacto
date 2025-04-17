import { Role } from "./enum/Role";

export class Usuario {
    id !: string;
    nome !: string;
    email !: string;
    password !: string;
    perfil !: Role;
}
