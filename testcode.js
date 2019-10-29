/*
 * 検索条件部 変更イベント
 */
function onConditionChange() {

    var targetId = $(this).attr('id');
    
    switch(targetId) {
    case 'categoryType':
        '';
        break;
    case 'categoryCode':
        '';
        break;
    case 'lineNo':
        // 更新モートの時に、
        if ($('#actionMode').val() == '20' &&  $('#lineNo').val() == $('orgLineNo').val()) {

            $('#confirmBtn').prop('disabled', updateFlg);
        }
        break;
    }
}
