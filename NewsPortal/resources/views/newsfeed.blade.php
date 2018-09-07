@extends('master')

@section('title')
    OKAY
@endsection

@section('content')

	 <style type="text/css">
         .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
                background-color: #F0F8FF  ;
             }
            .table-striped > tbody > tr:nth-child(2n+1) > td, .table-striped > tbody > tr:nth-child(2n+1) > th {
                background-color: #F0F8FF;
            }
             .table-striped > tbody > tr:nth-child(2n+1) > td, .table-striped > tbody > tr:nth-child(2n) > th {
                background-color: #F0F8FF;
            }
         
        </style>

	<div class="row container">
		<div class=" col-md-9"> 
			<h1>{{ $news->newsTitle }}</h1>
			<p>{{ $news->newsBody }} </p>
		</div>	
		<div class="col-md-3">
			<table class="table  table-hover table-striped ">
            	<thead>
              		<h3>Top News</h3>

              		<tr >
                 		<th>Headlines</th>
              		</tr>
            	</thead>
            	
            	<tbody>
            	@php 
            	$cnt = 0;
            	@endphp

            	@foreach($newsAll as $nws)
            		@if($nws->newsPriority == "Top")
            		<tr >
            			 
                 		<th> <a  style="color: black;" href="{{ route('newsfeed', ['news_id' => $nws->id] ) }}" class='title'> {{ $nws->newsTitle }}  </a> </th>
                 		
              		</tr>
              		@php 
            			$cnt++;
            			
            		@endphp

              		@endif

              		@php 
            		
            			if($cnt == 10) break;
            		@endphp

            	@endforeach
            	</tbody>
            
            </table>

            <table class="table  table-hover table-striped ">
            <thead>
              <h3>Latest News</h3>

              <tr >
                 <th>Headlines</th>
              </tr>
            </thead>
            <tbody>
            @php 
            	$cnt = 0;

            @endphp

            	@foreach($newsAll as $nws)
            		@if($nws->newsPriority != "Top")
            		<tr >
            			 
                 		<th> <a  style="color: black;" href="{{ route('newsfeed', ['news_id' => $nws->id] ) }}" class='title'> {{ $nws->newsTitle }}  </a> </th>
                 		
              		</tr>
              		@php 
            			$cnt++;
            			
            		@endphp

              		@endif
            		 @php 
            			
            			if($cnt == 10) break;
            		@endphp

            	@endforeach


            	</tbody>
            
            </table>
		</div>
	</div>

@endsection