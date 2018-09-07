@extends('master')

@section('title')
    OKAY
@endsection

@section('content')
    <style type="text/css">
            .title:hover{
                text-decoration: none;
            }

            #lightSlider {
                background-color: grey; 

            }

            #lightSlider ul{
                position: absolute;
            }

            #lightSlider li{
                width  : 100% !important;
                height : 250px;
                margin: auto;
                text-align: center;
                top : 50%;
                margin-top: -20px;
            }

        /*    #lightSlider p{
                width  :  80% !important;
                margin: auto;
                height : 80px;
            }*/

    </style>

   <script type="text/javascript">
$(document).ready(function() {
    $("#lightSlider").lightSlider({
        item: 3,
        autoWidth: false,
        slideMove: 1, // slidemove will be 1 if loop is true
        slideMargin: 10,
 
        addClass: '',
        mode: "",
        useCSS: true,
        cssEasing: 'ease', //'cubic-bezier(0.25, 0, 0.25, 1)',//
        easing: 'linear', //'for jquery animation',////
 
        speed: 400, //ms'
        auto: true,
        loop: true,
        slideEndAnimation: true,
        pause: 2000,
 
        keyPress: false,
        controls: true,
        prevHtml: '',
        nextHtml: '',
 
        rtl:false,
        adaptiveHeight:false,
 
        vertical:false,
        verticalHeight:500,
        vThumbWidth:100,
 
        thumbItem:10,
        pager: true,
        gallery: false,
        galleryMargin: 5,
        thumbMargin: 5,
        currentPagerPosition: 'middle',
 
        enableTouch:true,
        enableDrag:true,
        freeMove:true,
        swipeThreshold: 40,
 
        responsive : [],
 
        onBeforeStart: function (el) {},
        onSliderLoad: function (el) {},
        onBeforeSlide: function (el) {},
        onAfterSlide: function (el) {},
        onBeforeNextSlide: function (el) {},
        onBeforePrevSlide: function (el) {}
    });
});
</script>


    <div class="row">
 
        
        <ul id="lightSlider">
           
            @php 
            $cnt = 1;
            @endphp


          @foreach($news as $nws)
          
              @if($nws->newsPriority == "Top")
               <li >
              <a  style="color: black;" href="{{ route('newsfeed', ['news_id' => $nws->id] ) }}" class='title'>
              <h3>{{ $nws->newsTitle }}</h3>
              </a>
                  @php 
                 $cnt++;
                    if($cnt == 6) break;
                 @endphp
                </li>
              @endif
            


           
         @endforeach
        </ul>
    
 
 
 

   </div>


    <div class="container">
        @php 
            $cnt = 1;
        @endphp
        <div class="row">
        @foreach($news as $nws) 

        
            
            <div class="col-md-6">
                <div class="thumbnail">
                    
                    <div class="caption">
                        <a  style="color: black;" href="{{ route('newsfeed', ['news_id' => $nws->id] ) }}" class='title'>
                        <h3  >  {{ $nws->newsTitle }}  </h3>
                        </a>
                        
                        <p>{{ str_limit($nws->newsBody,250) }}</p>
                        
                        @if(strlen($nws->newsBody) > 250)
                         <p><a href="{{ route('newsfeed', ['news_id' => $nws->id] ) }}" role="button">..see more</a> </p>
                        @endif 
                    </div>
                </div>
            </div>

            @if($cnt%2 == 0 )
            </div>
            <div class="row">
            @endif


            @php 
                    $cnt++;
                    
            @endphp

        @endforeach

        @if($cnt%2 == 0 )
        </div>

        @endif
    </div>






@endsection