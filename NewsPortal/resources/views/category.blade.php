@extends('master')

@section('title')
    Category
@endsection

@section('content')
		<div class="container">
				<h1> 
				{{ $msg }}
				</h1>

				 @php 
            	$cnt = 1;
        		@endphp
		        <div class="row">
		        @foreach($newsAll as $nws) 

		        
		            
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
		</div>


@endsection