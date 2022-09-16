# Navigation

Navigation implementation in modularization is hot topic, and there are lots of discussion going on.

With Android Navigation Component, we could define `nav_graph.xml` for fragment transition. However it doesn't help for activity transition.

In addition, when we change any user flow of fragment, it could impact to all navigation graph that defined in the application.

## Problems

1. As mention in [Communication between features](../../../#communication-between-features) section, if the application is modularized in feature-based, each feature doesn't know each other. Transition from one feature to another one is not possible.

2. With Android Navigation Component, we could define `nav_graph.xml` for fragment transition. However it doesn't help for activity transition.

3. It is nightmare with screen transition of the application is complicated. Assume there are N screens and each screen can reach to each other. There will be 
   
   $$
   N  (N - 1)
   $$
   
   edges. When there is any screen updated, lots of definition in dependency graph need to be updated too.
   
   <img src="./screen%20transition.png" title="" alt="" data-align="center">

## Ideas

Here is the basic implementation, in order to transite activity / fragment

```kotlin
// activity
val intent = Intent(activityContext, TargetActivity::class.java)
activityContext.startActivity(intent)

// fragment
fragmentManager.beginTransaction()
        .replace(R.id.fragment_holder, TargetFragment())
        .commit()
```

The critical part of coupling of screens(activity/fragment) is

```kotlin
// activity
TargetActivity::class.java

// fragment
TargetFragment()
```

If it could be abstracted, actually we don't need to know other screens from current one.

This is the idea of final output

```kotlin
// activity
navigatorFactory.get(TargetNavigator::class.java)
        ?.createIntent(activityContext, Param(parameters))
        ?.run {
            activityContext.startActivity(this)
        }

// fragment
navigatorFactory.get(TargetNavigator::class.java)
        ?.createFragment(Param(parameters))
        ?.run {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_holder, this)
                .commit()
        }

```

With this idea, we could decouple the screen transition within the same module / with external module.

In the sample project, there are more details and samples

**Sample project**

[Navigation Sample](./sample)

# References

[Android Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)
