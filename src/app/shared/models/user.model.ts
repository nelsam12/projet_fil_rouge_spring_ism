export interface User {
  id: number;
  name: string;
  login : string;
  password: string;
  role : Role;
}

export type Role = "Client" | "Admin";

export enum RoleEnum {
  Admin = "Admin",
  Client = "Client",
}

export interface LoginResponse {
  message: string;
  success: boolean;
  data: User|null;
}
