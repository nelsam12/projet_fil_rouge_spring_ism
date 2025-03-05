import {Observable} from 'rxjs';
import {ProduitCatalogue} from '../models/catalogue.model';

export interface ICatalogueService {
  getProductsCatalogues():Observable<ProduitCatalogue[]>;
}
