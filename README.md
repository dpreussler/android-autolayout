android-autolayout
==================
Write less code!
Dont inflate views, menus anymore manually!


Why glue together your Activity and Fragments with the xml file manually?
Keep the names in sync and it will be done for you.

Simple extend from one of:

```java
AutoLayoutActivity
AutoLayoutFragment
AutoLayoutPreferenceFragment
```

both will do setContentView in onCreate / inflateView in onCreateView based on their name using
lowercase and underscores instead of CamelCase.

So:
`DashboardStatisticsActivity`
must have a layout file
`dashboard_statistics_activity.xml`
it also searches for
`dashboard_statistics.xml`
and
`dashboard.xml`

They also try to inflate the menu based on same names in menu folders!


If this is too dangerous for you because of changing names, you could also:
Just annotate your class:

```java
@InjectedLayout(R.id.myLayout)
public class MyActivity extends AutoLayoutActivity
```

or with fragment:

```java
@InjectedLayout(R.id.myLayout)
public class MyFragment extends AutoLayoutFragment
```


Licensed under MIT license
(c) 2014 Danny Preussler