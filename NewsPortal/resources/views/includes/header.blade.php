<header>

    <nav class="navbar  navbar-inverse bg-inverse navbar-backgrnd">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="{{ route('home') }}">The Daily News</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                @php 
                    $national = "national";
                    $international    = "international";
                    $sports  = "sports";
                    $entertainment = "entertainment";
                @endphp

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="{{ route('news.category', ['news' => $national] ) }}">National</a></li>
                            <li><a href="{{ route('news.category', ['news' => $international] ) }}">International</a></li>
                            <li><a href="{{ route('news.category', ['news' => $entertainment] ) }}">Entertainment</a></li>
                            <li><a href="{{ route('news.category', ['news' => $sports] ) }}">Sports</a></li>
                        </ul>

                    </li>
                    @if(auth()->check())
                        <li><a href="{{ route('about') }}">     About Us      </a></li>
                        <li><a href="{{ route('write') }}">     Write       </a></li>
                        @if(Auth::user()->type == "Admin" )
                        <li><a href="{{ route('user_edit') }}"> Users        </a></li>
                        @endif
                        <li><a href="{{ route('dashboard', ['user_id' =>  Auth::user()->id ]) }}"> Dashboard        </a></li>
                        <li><a href="{{ route('signout') }}">     Sign Out      </a></li>
                    @else
                        <li><a href="{{ route('editor') }}">    Sign In       </a></li>
                        <li><a href="{{ route('about') }}">     About Us      </a></li>
                    @endif

                    

                    

                </ul>
                </ul>

            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</header>