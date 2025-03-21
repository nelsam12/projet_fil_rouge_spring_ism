import { Injectable } from '@angular/core';
import {ProduitCatalogue, ProduitDetail} from '../../models/catalogue.model';
import {ICatalogueService} from '../ICatalogueService';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

// Singleton + Injection de dépendance
@Injectable({
  providedIn: 'root' //
})
export class CatalogueService implements ICatalogueService{

  constructor(private httpClient: HttpClient) { }

  getProductsCatalogues(): Observable<ProduitCatalogue[]> {
    return this.httpClient.get<ProduitCatalogue[]>("http://localhost:8080/api/produits");
  }
  
  getProductDetailCatalogue(produitId : number): Observable<ProduitDetail> {
    return this.httpClient.get<ProduitDetail>(`http://localhost:8080/api/produits/detail/${produitId}`);
  }
  
}
