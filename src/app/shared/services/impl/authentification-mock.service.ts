import {Injectable, signal} from '@angular/core';
import {LoginResponse, Role, User} from '../../models/user.model';
import {IAuthService} from '../IAuthService';
import {Observable, of} from 'rxjs';
import {MOCK_USER} from '../../mock/user.mock';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationMockService implements IAuthService{
  currentUserSignal = signal<User|null>(null);
  constructor() { }

  isAuthenticated(): boolean {
    return !!this.currentUserSignal();
  }

  login(username: string, password: string): Observable<LoginResponse> {
    const userConnect = MOCK_USER.find((user:User)=>user.login==username && user.password==password);
    if (userConnect) {
      this.currentUserSignal.set(userConnect);
      return of(
        {
          message: 'Login successfully',
          success : true,
          data : userConnect
        }
      );
    }

    return of(
      {
        message: 'ERROR : Login failed',
        success : false,
        data : null
      }
    );

  }

  logout(): void {
    this.currentUserSignal.set(null);
  }

  isAdmin(): boolean {
    return this.isAuthenticated() && this.currentUserSignal()?.role === 'Admin';
  }

  isClient(): boolean {
    return this.isAuthenticated() && this.currentUserSignal()?.role === 'Client';
  }

  hasRole(role: Role): boolean {
    return this.isAuthenticated() && this.currentUserSignal()?.role === role;
    // return true;
  }
}
