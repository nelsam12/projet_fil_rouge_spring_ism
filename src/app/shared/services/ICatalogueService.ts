import {Observable} from 'rxjs';
import {ProduitDetail, ProduitCatalogue} from '../models/catalogue.model';

export interface ICatalogueService {
  getProductsCatalogues():Observable<ProduitCatalogue[]>;
  getProductDetailCatalogue(produitId : number):Observable<ProduitDetail>;
}
