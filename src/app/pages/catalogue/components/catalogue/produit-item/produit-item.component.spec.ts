import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitItemComponent } from './produit-item.component';

describe('ProduitItemComponent', () => {
  let component: ProduitItemComponent;
  let fixture: ComponentFixture<ProduitItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProduitItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduitItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
