import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL = 'https://backendailingnz.onrender.com/educacion/';

  constructor(private httpclient: HttpClient) { }

  public lista(): Observable<Educacion[]> {
    return this.httpclient.get<Educacion[]>(this.URL + 'lista');
  }

  public details(id: number): Observable<Educacion> {
    return this.httpclient.get<Educacion>(this.URL + `details/${id}`);
  }

  public save(educacion: Educacion): Observable<any> {
    return this.httpclient.post<any>(this.URL + 'create', educacion);
  }

  public update(id: number, educacion: Educacion): Observable<any> {
    return this.httpclient.put<any>(this.URL + `update/${id}`, educacion);
  }

  public delete(id: number): Observable<any> {
    return this.httpclient.delete<any>(this.URL + `delete/${id}`);
  }
}
