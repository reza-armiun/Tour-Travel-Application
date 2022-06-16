import {ToursStore} from "./tours.store";
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {TestBed} from "@angular/core/testing";
import {LoadingService} from "../shared/loading/loading.service";
import {MessagesService} from "../shared/messages/messages.service";
import {ModalBackgroundService} from "../shared/modal-background/modal-background.service";


describe('tours store  test' , () => {
  let toursStore: ToursStore,
    httpTestingController: HttpTestingController;

  beforeEach(() => {
    let spy
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [
        ToursStore,
        LoadingService,
        MessagesService,
        ModalBackgroundService
      ]
    });

    toursStore = TestBed.inject(ToursStore);
    httpTestingController = TestBed.inject(HttpTestingController);
  })

  it('should load all tours', () => {
    toursStore.loadAllTours().subscribe(tours => {

    });
    const req = httpTestingController.expectOne('/v1/tour');
    // expect(req.request.method).toEqual('GET');

    req.flush([]);
  });

  afterEach(() => {
    httpTestingController.verify();
  })


});
