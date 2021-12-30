import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodlayoutComponent } from './foodlayout.component';

describe('FoodlayoutComponent', () => {
  let component: FoodlayoutComponent;
  let fixture: ComponentFixture<FoodlayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoodlayoutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FoodlayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
