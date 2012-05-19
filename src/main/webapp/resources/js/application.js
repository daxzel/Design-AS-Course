 $(document).ready(function(){
            $(".jquery_tabs").accessibleTabs({
                tabhead:'h4',
                fx:"fadeIn"
            });
             $('.table_pie').visualize({type: 'pie', parseDirection:'y', height: 250, width: 600  });
              $('.table_line').visualize({type: 'line', parseDirection:'x', height: 250, width: 600  });



        });