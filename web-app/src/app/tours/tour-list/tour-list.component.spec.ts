import {ComponentFixture, fakeAsync, flush, TestBed, waitForAsync} from "@angular/core/testing";
import {ToursComponent} from "../tours.component";
import {DebugElement} from "@angular/core";
import {AppModule} from "../../app.module";
import {NoopAnimationsModule} from "@angular/platform-browser/animations";
import {ToursStore} from "../../stores/tours.store";
import {of} from "rxjs";
import {By} from "@angular/platform-browser";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {CommonModule} from "@angular/common";


describe('Tour List Component Test', () => {

  let fixture: ComponentFixture<ToursComponent>;
  let component:ToursComponent;
  let el: DebugElement;
  let tourStore: any;

  beforeEach(waitForAsync(() => {
    const tourStoreSpy = jasmine.createSpyObj('ToursStore', ['loadAllTours', 'filteredTourList$'])

    TestBed.configureTestingModule({
      imports: [
        CommonModule,
        HttpClientTestingModule,
        // AppModule,
        NoopAnimationsModule
      ],
      providers: [
        // HttpClientTestingModule,
        // ToursStore
        {provide: ToursStore, useValue: tourStoreSpy}
      ]
    }).compileComponents()
      .then(() => {
        fixture = TestBed.createComponent(ToursComponent);
        component = fixture.componentInstance;
        el = fixture.debugElement;
        tourStore = TestBed.inject(ToursStore);
      });

  }))
  it('Should display tour list', fakeAsync(() => {
        tourStore.filteredTourList$.and.returnValue(of([]));
         fixture.detectChanges();
        const  tours = el.queryAll(By.css('.tour'));
        flush();
        // @ts-ignore
    expect(tours.length).toBe(0);
  }))
})
