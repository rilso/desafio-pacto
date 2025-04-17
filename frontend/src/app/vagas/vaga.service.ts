import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class VagaService {
  private apiUrl = 'http://localhost:8080/vagas';

  constructor(private http: HttpClient) {}

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  candidatar(idVaga: number): Observable<any> {
    return this.http.post('http://localhost:8080/candidaturas', { idVaga });
  }

  buscarPorId(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  criar(vaga: any): Observable<any> {
    return this.http.post(this.apiUrl, vaga);
  }

  atualizar(id: number, vaga: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, vaga);
  }

  excluir(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
