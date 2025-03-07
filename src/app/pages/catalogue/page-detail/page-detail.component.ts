import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CatalogueService } from '../../../shared/services/impl/catalogue.service';
import { ProduitDetail } from '../../../shared/models/catalogue.model';
import { ProduitItemComponent } from "../../../components/catalogue/produit-item/produit-item.component";

@Component({
  selector: 'ism-page-detail',
  imports: [ProduitItemComponent],
  templateUrl: './page-detail.component.html',
  styleUrl: './page-detail.component.css'
})
export class PageDetailComponent implements OnInit{

  constructor(private route: ActivatedRoute, private catalogueService: CatalogueService){
  }

  produitDetail? : ProduitDetail

  ngOnInit(): void {
    let id = this.route.snapshot.params['product_id']
    this.catalogueService.getProductDetailCatalogue(id).subscribe(
      data => {
        this.produitDetail = data
        // console.log(data.relatedProducts)
      },
      error => console.log(error)
    )
  }

  onValidateQte(){
    
  }

}
