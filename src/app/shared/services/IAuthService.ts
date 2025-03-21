import {LoginResponse, Role} from '../models/user.model';
import {Observable} from 'rxjs';

export interface IAuthService {
  login(username: string, password: string): Observable<LoginResponse>;
  logout(): void;
  isAuthenticated(): boolean;
  isClient(): boolean;
  isAdmin(): boolean;
  hasRole(role : Role): boolean;

}
