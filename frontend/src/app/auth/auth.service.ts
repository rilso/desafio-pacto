import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { TokenService } from './token/token.service';
import { Usuario } from '../core/model/usuario.model';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private api = 'http://localhost:8080/auth';
  private tokenKey = 'jwt_token';

  constructor(private http: HttpClient, private tokenService: TokenService) {}

  login(usuario: Usuario): Observable<any> {
    return this.http.post<any>(`${this.api}/login`, usuario).pipe(
      catchError(this.handleError)
    );
  }

  logout() : boolean {
    this.tokenService.removeToken();
    this.tokenService.removeUID();
    return true;
  }

  register(data: any): Observable<any> {
    return this.http.post(`${this.api}/register`, data, { responseType: 'text' });
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error('Ocorreu um erro:', error.error.message);
    } else {
      console.error(`Código de erro ${error.status}, ` + `mensagem: ${error.error}`);
    }
    return throwError('Não foi possível realizar o Login, verifique os dados!.');
  }
}
